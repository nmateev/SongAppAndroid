package com.wasp.songapp.views.addnewsong;

import android.content.Intent;
import android.os.Bundle;
import com.wasp.songapp.R;
import com.wasp.songapp.views.BaseDrawerActivity;
import com.wasp.songapp.views.mysongslist.MySongsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SongCreateActivity extends BaseDrawerActivity implements SongCreateContracts.Navigator {
    //fields
    public static final long IDENTIFIER = 298;
    @Inject
    SongCreateFragment mView;

    @Inject
    SongCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_create);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_song_create, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MySongsListActivity.class);
        startActivity(intent);
        finish();
    }
}




