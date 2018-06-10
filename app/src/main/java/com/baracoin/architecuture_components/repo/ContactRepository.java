package com.baracoin.architecuture_components.repo;

import android.arch.lifecycle.LiveData;

import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by PMohale on 2018/06/10.
 */

public interface ContactRepository {

    Completable addContact(Contact contact);

    Completable deleteContact(Contact contact);

    LiveData<List<Contact>> getAllContacts();
}
