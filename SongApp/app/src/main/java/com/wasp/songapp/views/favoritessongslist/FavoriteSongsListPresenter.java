package com.wasp.songapp.views.favoritessongslist;

import com.wasp.songapp.async.base.SchedulerProvider;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.services.base.SongsService;
import com.wasp.songapp.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class FavoriteSongsListPresenter implements FavoriteSongsListContracts.Presenter {

    private FavoriteSongsListContracts.View mView;
    private final SongsService mSongsService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    FavoriteSongsListPresenter(SongsService songsService, SchedulerProvider schedulerProvider) {

        mSongsService = songsService;
        mSchedulerProvider = schedulerProvider;

    }


    @Override
    public void subscribe(FavoriteSongsListContracts.View view) {
        mView = view;
    }


    @Override
    public void showSongsList() {

        mView.showProgressBarLoading();

        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Song>>) emitter -> {
                    List<Song> songs = mSongsService.getFavoriteSongs();
                    emitter.onNext(songs);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.backgroundThread())
                .observeOn(mSchedulerProvider.uiThread())
                .doFinally(mView::hideProgressBarLoading)
                .subscribe(allSongs -> presentSongsToView(allSongs, Constants.NO_SONGS_AVAILABLE_MESSAGE), mView::showError);
    }


    @Override
    public void presentSongsToView(List<Song> allSongs, String message) {

        if (allSongs.isEmpty()) {
            mView.showMessage(message);
        } else {
            mView.showAllSongs(allSongs);
        }
    }


    @Override
    public void songIsSelected(Song song) {
        mView.showSongDetails(song);
    }

}
