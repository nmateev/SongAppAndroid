package com.wasp.songapp.views.mysongslist;

import com.wasp.songapp.models.Song;

import java.util.List;

public interface MySongsListContracts {
    interface View {

        void setPresenter(MySongsListContracts.Presenter presenter);

        void showSongDetails(Song song);

        void showProgressBarLoading();

        void hideProgressBarLoading();

        void showError(Throwable error);

        void showAllSongs(List<Song> allSongs);

        void showEmptyListMessage();
    }

    interface Presenter {

        void subscribe(MySongsListContracts.View view);

        void selectSong(Song song);

        void showSongsList();

        void presentSongsToView(List<Song> allSongs);

    }

    interface Navigator {
        void navigateToSongDetailsWith(Song song);
    }
}
