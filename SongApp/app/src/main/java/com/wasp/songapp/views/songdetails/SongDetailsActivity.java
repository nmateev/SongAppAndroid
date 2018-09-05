package com.wasp.songapp.views.songdetails;

import android.content.Intent;
import android.os.Bundle;
import com.wasp.songapp.R;
import com.wasp.songapp.models.Song;
import com.wasp.songapp.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SongDetailsActivity extends BaseDrawerActivity {

    public static final String EXTRA_KEY = "SONG_EXTRA_KEY";

    @Inject
    SongDetailsFragment mSongDetailsFragment;

    @Inject
    SongDetailsContracts.Presenter mSongDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra(SongDetailsActivity.EXTRA_KEY);

        mSongDetailsPresenter.setSongId(song.getId());
        mSongDetailsFragment.setPresenter(mSongDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.song_activity, mSongDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }

}
