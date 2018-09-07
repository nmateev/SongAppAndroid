package com.wasp.songapp.views.favoritessongslist;

import android.content.Intent;
import android.os.Bundle;

import com.wasp.songapp.R;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.views.BaseDrawerActivity;
import com.wasp.songapp.views.songdetails.SongDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class FavoriteSongsListActivity extends BaseDrawerActivity implements FavoriteSongsListContracts.Navigator {
    public static final int DRAWER_IDENTIFIER = 315;
    @Inject
    FavoriteSongsListFragment mFavoriteSongsListFragment;

    @Inject
    FavoriteSongsListPresenter FavoriteSongsListPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_songs_list);
        ButterKnife.bind(this);

        mFavoriteSongsListFragment.setNavigator(this);
        mFavoriteSongsListFragment.setPresenter(FavoriteSongsListPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_favorite_songs_list_fragment, mFavoriteSongsListFragment)
                .commit();
    }


    @Override
    public void navigateToSongDetailsWith(Song song) {

        Intent intent = new Intent(this, SongDetailsActivity.class);
        intent.putExtra(SongDetailsActivity.SONG_EXTRA_KEY, song);
        startActivity(intent);
    }

    @Override
    protected long getIdentifier() {
        return DRAWER_IDENTIFIER;
    }
}