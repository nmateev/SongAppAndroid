package com.wasp.songapp.views.addnewsong;

import com.wasp.songapp.async.base.SchedulerProvider;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.services.base.SongsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SongCreatePresenter implements SongCreateContracts.Presenter {
    private final SongsService mSongsService;
    private final SchedulerProvider mSchedulerProvider;
    private SongCreateContracts.View mView;

    @Inject
    public SongCreatePresenter(
            SongsService superheroesService,
            SchedulerProvider schedulerProvider) {
        mSongsService = superheroesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(SongCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void save(Song song) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Song>) emitter -> {
                    mSongsService.addSong(song);
                    emitter.onNext(song);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.backgroundThread())
                .observeOn(mSchedulerProvider.uiThread())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s -> mView.navigateToHome());
    }

}
