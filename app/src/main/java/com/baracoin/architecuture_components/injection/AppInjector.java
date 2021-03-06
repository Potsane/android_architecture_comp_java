package com.baracoin.architecuture_components.injection;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.baracoin.architecuture_components.App;

import dagger.android.AndroidInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by PMohale on 2018/06/10.
 */

public class AppInjector {

    public AppInjector() {
    }

    public static void init(App contactsManagerApplication) {
        DaggerContactsManagerComponent.builder().application(contactsManagerApplication)
                .build().inject(contactsManagerApplication);

        contactsManagerApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                handleActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private static void handleActivity(Activity activity) {

        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
        }
    }
}
