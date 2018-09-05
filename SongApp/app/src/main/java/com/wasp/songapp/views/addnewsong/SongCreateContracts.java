package com.wasp.songapp.views.addnewsong;

import com.wasp.songapp.models.Song;

public interface SongCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Song song);
    }

    public interface Navigator {

        void navigateToHome();
    }

}
