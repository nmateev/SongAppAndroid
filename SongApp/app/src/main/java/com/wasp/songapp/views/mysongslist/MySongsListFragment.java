package com.wasp.songapp.views.mysongslist;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wasp.songapp.R;
import com.wasp.songapp.models.Song;

import java.util.List;

import javax.inject.Inject;


public class MySongsListFragment extends Fragment implements MySongsListContracts.View {
    private static final String NO_SONGS_AVAILABLE_MESSAGE = "Your song list is empty";
    private MySongsListContracts.Presenter mPresenter;
    private MySongsListContracts.Navigator mNavigator;


    @Inject
    public MySongsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_songs_list, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.showSongsList();
    }

    @Override
    public void setPresenter(MySongsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showSongDetails(Song song) {
        mNavigator.navigateToSongDetailsWith(song);
    }

    @Override
    public void showProgressBarLoading() {

    }

    @Override
    public void hideProgressBarLoading() {

    }

    @Override
    public void showError(Throwable error) {

    }

    @Override
    public void showAllSongs(List<Song> allSongs) {

    }

    @Override
    public void showEmptyListMessage() {
        Toast
                .makeText(getContext(), NO_SONGS_AVAILABLE_MESSAGE, Toast.LENGTH_LONG)
                .show();
    }


    public void setNavigator(MySongsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}
