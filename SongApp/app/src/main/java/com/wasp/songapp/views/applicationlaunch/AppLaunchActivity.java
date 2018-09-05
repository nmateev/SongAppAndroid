package com.wasp.songapp.views.applicationlaunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wasp.songapp.R;
import com.wasp.songapp.views.songslist.SongsListActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AppLaunchActivity extends DaggerAppCompatActivity implements AppLaunchContracts.Navigator {

    @Inject
    AppLaunchFragment mAppLaunchFragment;
    @Inject
    AppLaunchContracts.Presenter mAppLaunchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_app);

        mAppLaunchFragment.setNavigator(this);
        mAppLaunchFragment.setPresenter(mAppLaunchPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_app_launch, mAppLaunchFragment)
                .commit();
    }


    @Override
    public void navigateToNextActivity() {
        Intent intent = new Intent(this, SongsListActivity.class);
        startActivity(intent);
        finish();
    }
}
