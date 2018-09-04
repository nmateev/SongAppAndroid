package com.wasp.songapp.diconfig;

import android.app.Application;

import com.wasp.songapp.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
})

public interface AppComponent extends AndroidInjector<AndroidApplication> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
