package com.baracoin.architecuture_components.repo;

import android.arch.lifecycle.LiveData;

import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by PMohale on 2018/06/10.
 */

public class ContactRepositoryImpl implements ContactRepository {

    @Override
    public LiveData<Contact> addContact(Contact contact) {
        return null;
    }

    @Override
    public Completable deleteContact(long id) {
        return null;
    }

    @Override
    public LiveData<List<Contact>> getAllContacts() {
        return null;
    }
}
