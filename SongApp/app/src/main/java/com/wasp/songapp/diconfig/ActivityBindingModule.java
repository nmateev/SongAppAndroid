package com.wasp.songapp.diconfig;

import com.wasp.songapp.views.applicationlaunch.AppLaunchActivity;
import com.wasp.songapp.views.mysongslist.MySongsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = AppLaunchModule.class)
    abstract AppLaunchActivity appLaunchActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = MySongsListModule.class)
    abstract MySongsListActivity mySongsListActivity();

}
