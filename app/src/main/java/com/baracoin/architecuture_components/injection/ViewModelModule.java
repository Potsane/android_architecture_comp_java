package com.baracoin.architecuture_components.injection;

import android.arch.lifecycle.ViewModel;

import com.baracoin.architecuture_components.view.list.ContactListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by PMohale on 2018/06/10.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactListViewModel.class)
    abstract ViewModel bindContactsListViewModel(ContactListViewModel contactListViewModel);
}
