package com.baracoin.architecuture_components.view.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.baracoin.architecuture_components.entity.Contact;
import com.baracoin.architecuture_components.repo.ContactRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PMohale on 2018/06/10.
 */

public class ContactListViewModel extends ViewModel {

    @Inject
    ContactRepository contactRepository;

    @Inject
    public ContactListViewModel() {
    }

    public void deleteContact(Contact contact) {
        contactRepository.deleteContact(contact)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public LiveData<List<Contact>> getAllContacts() {
        return contactRepository.getAllContacts();
    }
}