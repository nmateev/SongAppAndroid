package com.wasp.songapp.views.mysongslist;

import com.wasp.songapp.async.base.SchedulerProvider;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.services.base.SongsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MySongsListPresenter implements MySongsListContracts.Presenter {

    private MySongsListContracts.View mView;
    private final SongsService mSongsService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    MySongsListPresenter(SongsService songsService, SchedulerProvider schedulerProvider) {

        mSongsService = songsService;
        mSchedulerProvider = schedulerProvider;

    }


    @Override
    public void subscribe(MySongsListContracts.View view) {
        mView = view;
    }

    @Override
    public void selectSong(Song song) {
        mView.showSongDetails(song);
    }

    @Override
    public void showSongsList() {

        mView.showProgressBarLoading();

        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Song>>) emitter -> {
                    List<Song> songs = mSongsService.getAllSongs();
                    emitter.onNext(songs);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.backgroundThread())
                .observeOn(mSchedulerProvider.uiThread())
                .doFinally(mView::hideProgressBarLoading)
                .subscribe(
                        this::presentSongsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void presentSongsToView(List<Song> allSongs) {

        if(allSongs.isEmpty()){
            mView.showEmptyListMessage();
        }else {
            mView.showAllSongs(allSongs);
        }
    }
}
