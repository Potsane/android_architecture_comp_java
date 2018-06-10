package com.baracoin.architecuture_components.injection;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * Created by PMohale on 2018/06/10.
 */

@Module(includes = {AndroidInjectionModule.class, ViewModelModule.class})
class ContactsManagerModule {
}
