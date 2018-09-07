package com.wasp.songapp.diconfig;

import com.wasp.songapp.views.favoritessongslist.FavoriteSongsListContracts;
import com.wasp.songapp.views.favoritessongslist.FavoriteSongsListFragment;
import com.wasp.songapp.views.favoritessongslist.FavoriteSongsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class FavoriteSongsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract FavoriteSongsListFragment favoriteSongsListFragment();

    @ActivityScoped
    @Binds
    abstract FavoriteSongsListContracts.Presenter presenter(FavoriteSongsListPresenter presenter);

}
