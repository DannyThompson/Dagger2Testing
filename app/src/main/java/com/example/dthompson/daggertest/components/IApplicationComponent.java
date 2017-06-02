package com.example.dthompson.daggertest.components;

import com.example.dthompson.daggertest.MyApplication;
import com.example.dthompson.daggertest.modules.ActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {ActivityModule.class, AndroidInjectionModule.class})
public interface IApplicationComponent {
    void inject(MyApplication application);
}

