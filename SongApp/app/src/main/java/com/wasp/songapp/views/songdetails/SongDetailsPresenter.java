package com.wasp.songapp.views.songdetails;

import com.wasp.songapp.async.base.SchedulerProvider;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.services.base.SongsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SongDetailsPresenter implements SongDetailsContracts.Presenter {
    //fields
    private final SongsService mSongsService;
    private final SchedulerProvider mSchedulerProvider;
    private SongDetailsContracts.View mView;
    private int mSongId;

    //constructor
    @Inject
    public SongDetailsPresenter(SongsService songsService, SchedulerProvider schedulerProvider) {
        mSongsService = songsService;
        mSchedulerProvider = schedulerProvider;
    }

    //methods
    @Override
    public void subscribe(SongDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadSong() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Song>) emitter -> {
                    Song song = mSongsService.getSongById(mSongId);
                    emitter.onNext(song);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.backgroundThread())
                .observeOn(mSchedulerProvider.uiThread())
                .doFinally(mView::hideLoading)
                .subscribe(mView::showSong, mView::showError);
    }

    @Override
    public void setSongId(int songId) {
        mSongId = songId;
    }

}
