package com.example.dthompson.daggertest.modules;



import android.app.Activity;

import com.example.dthompson.daggertest.components.IMainActivitySubcomponent;
import com.example.dthompson.daggertest.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module(subcomponents = {IMainActivitySubcomponent.class})
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory <? extends Activity>
        bindActivityInjectorFactory(IMainActivitySubcomponent.Builder builder);
}
