package com.baracoin.architecuture_components.repo;

import android.arch.lifecycle.LiveData;

import com.baracoin.architecuture_components.database.dao.ContactDao;
import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by PMohale on 2018/06/10.
 */

public class ContactRepositoryImpl implements ContactRepository {

    @Inject
    ContactDao contactDao;

    public ContactRepositoryImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Completable addContact(Contact contact) {
        return Completable.fromAction(() -> contactDao.addContact(contact));
    }

    @Override
    public Completable deleteContact(Contact contact) {
        return Completable.fromAction(()-> contactDao.deleteContact(contact));
    }

    @Override
    public LiveData<List<Contact>> getAllContacts() {
        return contactDao.getAllContacts();
    }
}
