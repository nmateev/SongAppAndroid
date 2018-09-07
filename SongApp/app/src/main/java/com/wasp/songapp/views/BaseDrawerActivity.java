package com.wasp.songapp.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryToggleDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.wasp.songapp.R;
import com.wasp.songapp.views.addnewsong.SongCreateActivity;
import com.wasp.songapp.views.favoritessongslist.FavoriteSongsListActivity;
import com.wasp.songapp.views.mysongslist.MySongsListActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    private static final String MY_SONGS_DRAWER_NAME = "My songs";
    private static final String ADD_NEW_SONG_DRAWER_NAME = "Add new song";
    private static final String FAVORITE_SONGS_DRAWER_NAME = "Favorite songs";

    @BindView(R.id.tb_drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {
        //empty constructor required
    }

    public void setupDrawer() {
        PrimaryDrawerItem mySongsListItem = new PrimaryDrawerItem()
                .withIdentifier(MySongsListActivity.DRAWER_IDENTIFIER)
                .withName(MY_SONGS_DRAWER_NAME);

        SecondaryDrawerItem addNewSongItem = new SecondaryDrawerItem()
                .withIdentifier(SongCreateActivity.DRAWER_IDENTIFIER)
                .withName(ADD_NEW_SONG_DRAWER_NAME);
        SecondaryDrawerItem favoriteSongsListItem=new SecondaryDrawerItem()
                .withIdentifier(FavoriteSongsListActivity.DRAWER_IDENTIFIER)
                .withName(FAVORITE_SONGS_DRAWER_NAME);

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getToolbar())
                .addDrawerItems(
                        mySongsListItem
                                .withIcon(R.drawable.drawermysongsicon),
                        new DividerDrawerItem(),
                        addNewSongItem
                                .withIcon(R.drawable.draweraddsongicon),
                        new DividerDrawerItem(),
                        favoriteSongsListItem
                        .withIcon(R.drawable.favoritesongsicon)
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    long identifier = drawerItem.getIdentifier();

                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);
                    if (intent == null) {
                        return false;
                    }
                    startActivity(intent);
                    return true;
                })
                .build();
    }


    private Intent getNextIntent(long identifier) {
        if (identifier == MySongsListActivity.DRAWER_IDENTIFIER) {
            Intent intent=new Intent(this, MySongsListActivity.class);
            this.finish();
            return intent;
        } else if (identifier == SongCreateActivity.DRAWER_IDENTIFIER) {
            Intent intent=new Intent(this, SongCreateActivity.class);
            this.finish();
            return intent;
        } else if(identifier==FavoriteSongsListActivity.DRAWER_IDENTIFIER){
            Intent intent=new Intent(this, FavoriteSongsListActivity.class);
            this.finish();
            return intent;
        }
        else {
            return null;
        }
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}


