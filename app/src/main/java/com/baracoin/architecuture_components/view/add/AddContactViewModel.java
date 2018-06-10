package com.baracoin.architecuture_components.view.add;

import android.arch.lifecycle.ViewModel;

import com.baracoin.architecuture_components.entity.Contact;
import com.baracoin.architecuture_components.repo.ContactRepository;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PMohale on 2018/06/10.
 */

public class AddContactViewModel extends ViewModel {

    @Inject
    ContactRepository contactRepository;

    @Inject
    public AddContactViewModel() {
    }

    public void addContact(Contact contact) {
        contactRepository.addContact(contact)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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
}
