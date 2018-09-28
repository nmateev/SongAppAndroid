package com.wasp.songapp.views.applicationlaunch;

public interface AppLaunchContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void showAppLaunchPicture();

        void getNavigation();

    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void loadAppLaunchPicture();

        void getNavigation();

    }

    interface Navigator {
        void navigateToNextActivity();
    }
}
