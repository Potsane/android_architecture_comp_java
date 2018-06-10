package com.baracoin.architecuture_components.injection;

import com.baracoin.architecuture_components.view.list.ContactsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by PMohale on 2018/06/10.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract ContactsListActivity bindContactsListActivity();
}
