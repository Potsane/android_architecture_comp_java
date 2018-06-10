package com.baracoin.architecuture_components.injection;

import com.baracoin.architecuture_components.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by PMohale on 2018/06/10.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class, ContactsManagerModule.class})

public interface ContactsManagerComponent {

    void inject(App contactsManagerApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App application);

        ContactsManagerComponent build();
    }
}
