package com.wasp.songapp.views.mysongslist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import com.wasp.songapp.R;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.views.songdetails.SongDetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;


//extend base drawer activity

public class MySongsListActivity extends DaggerAppCompatActivity implements MySongsListContracts.Navigator {

    @BindView(R.id.tb_drawer_toolbar)
    Toolbar mDrawerToolbar;

    @Inject
    MySongsListFragment mMySongsListFragment;

    @Inject
    MySongsListPresenter mySongsListPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        ButterKnife.bind(this);

        mMySongsListFragment.setNavigator(this);
        mMySongsListFragment.setPresenter(mySongsListPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_my_songs_list_fragment, mMySongsListFragment)
                .commit();
    }


    @Override
    public void navigateToSongDetailsWith(Song song) {

        Intent intent = new Intent(this, SongDetailsActivity.class);
        intent.putExtra(SongDetailsActivity.SONG_EXTRA_KEY, song);
        startActivity(intent);
    }
}
