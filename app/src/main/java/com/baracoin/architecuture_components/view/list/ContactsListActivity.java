package com.baracoin.architecuture_components.view.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.baracoin.architecuture_components.R;
import com.baracoin.architecuture_components.entity.Contact;
import com.baracoin.architecuture_components.injection.ContactsManagerViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ContactsListActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private ContactListAdapter contactListAdapter;
    private ContactListViewModel contactListViewModel;
    @Inject
    ContactsManagerViewModelFactory contactsManagerViewModelFactory;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupViewModels() {
        contactListViewModel = ViewModelProviders.of(this, contactsManagerViewModelFactory).get(ContactListViewModel.class);
        contactListViewModel.deleteContact(null); //TODO: delete
    }

    private View.OnClickListener deleteClickListener = v -> {

        Contact contact = (Contact) v.getTag();
        contactListViewModel.deleteContact(contact);
    };

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
