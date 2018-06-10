package com.baracoin.architecuture_components.injection;

import android.arch.persistence.room.Room;

import com.baracoin.architecuture_components.App;
import com.baracoin.architecuture_components.database.ContactManagementDatabase;
import com.baracoin.architecuture_components.database.dao.ContactDao;
import com.baracoin.architecuture_components.repo.ContactRepository;
import com.baracoin.architecuture_components.repo.ContactRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

/**
 * Created by PMohale on 2018/06/10.
 */

@Module(includes = {AndroidInjectionModule.class, ViewModelModule.class})
class ContactsManagerModule {

    @Provides
    ContactRepository providesContactRepository(ContactDao contactDao) {
        return new ContactRepositoryImpl(contactDao);
    }

    @Provides
    @Singleton
    ContactDao providesContactDao(ContactManagementDatabase contactManagementDatabase) {
        return contactManagementDatabase.contactDao();
    }

    @Provides
    @Singleton
    ContactManagementDatabase providesContactManagementDatabase(App context) {
        return Room.databaseBuilder(context.getApplicationContext(), ContactManagementDatabase.class, "contacts").build();
    }

}



