package com.wasp.songapp.views.favoritessongslist;

import com.wasp.songapp.models.Song;


import java.util.List;

public interface FavoriteSongsListContracts {

    interface View {

        void setPresenter(FavoriteSongsListContracts.Presenter presenter);

        void showSongDetails(Song song);

        void showProgressBarLoading();

        void hideProgressBarLoading();

        void showError(Throwable error);

        void showAllSongs(List<Song> allSongs);

        void showMessage(String message);
    }

    interface Presenter {

        void subscribe(FavoriteSongsListContracts.View view);

        void songIsSelected(Song song);

        void showSongsList();

        void presentSongsToView(List<Song> allSongs, String message);

    }

    interface Navigator {
        void navigateToSongDetailsWith(Song song);
    }
}
