package com.wasp.songapp.diconfig;

import com.wasp.songapp.models.Song;
import com.wasp.songapp.repositories.base.Repository;
import com.wasp.songapp.services.HttpSongsService;
import com.wasp.songapp.services.base.SongsService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public SongsService songsService(Repository<Song> repository) {
        return new HttpSongsService(repository);
    }
}
