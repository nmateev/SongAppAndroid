package com.wasp.songapp.views.songdetails;

import com.wasp.songapp.models.Song;

public interface SongDetailsContracts {

    interface View {
        void showSong(Song song);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadSong();

        void setSongId(int id);
    }



}
