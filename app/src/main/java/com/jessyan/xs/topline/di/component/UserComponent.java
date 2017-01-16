package com.jessyan.xs.topline.di.component;

import com.jess.arms.di.scope.ActivityScope;
import com.jessyan.xs.topline.di.module.UserModule;
import com.jessyan.xs.topline.mvp.ui.activity.UserActivity;

import common.AppComponent;
import dagger.Component;

/**
 * Created by jess on 9/4/16 11:17
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
