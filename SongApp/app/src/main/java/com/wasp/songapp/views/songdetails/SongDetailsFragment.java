package com.wasp.songapp.views.songdetails;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wasp.songapp.R;
import com.wasp.songapp.models.Song;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SongDetailsFragment extends Fragment
implements SongDetailsContracts.View{

    //fields
    private SongDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_song_title)
    TextView mTitleTextView;

    @BindView(R.id.tv_author_name)
    TextView mAuthorTextView;

    @BindView(R.id.tv_song_duration)
    TextView mSongDurationTextView;

    @BindView(R.id.tv_song_plays_count)
    TextView mSongPlaysCountTextView;

    @BindView(R.id.song_image)
    ImageView mSongImageView;

    //constructor
    @Inject
    public SongDetailsFragment() {
        // Required empty constructor here
    }

    //methods
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_song_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadSong();
    }

    @Override
    public void showSong(Song song) {
        mTitleTextView.setText(song.getSongTitle());
        mAuthorTextView.setText(song.getAuthorName());
        mSongDurationTextView.setText(song.getSongDuration());
        mSongPlaysCountTextView.setText(song.getPlaysCount());
        Picasso.get().load(song.getImageUrl()).into(mSongImageView);
    }

    @Override
    public void setPresenter(SongDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
