package com.baracoin.architecuture_components.view.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.baracoin.architecuture_components.R;
import com.baracoin.architecuture_components.entity.Contact;
import com.baracoin.architecuture_components.injection.ContactsManagerViewModelFactory;
import com.baracoin.architecuture_components.view.add.AddContactActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ContactsListActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private RecyclerView contactsRecyclerView;
    private ContactListAdapter contactListAdapter;
    private ContactListViewModel contactListViewModel;
    @Inject
    ContactsManagerViewModelFactory contactsManagerViewModelFactory;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupViewModels();
        setupRecyclerView();
        setupButtons();
    }

    private void setupRecyclerView() {
        contactsRecyclerView = findViewById(R.id.recycler_view_contact_items);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactListAdapter = new ContactListAdapter(this, new ArrayList<>(), deleteClickListener);
        contactsRecyclerView.setAdapter(contactListAdapter);
    }

    private void setupViewModels() {
        contactListViewModel = ViewModelProviders.of(this, contactsManagerViewModelFactory).get(ContactListViewModel.class);
        contactListViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable List<Contact> contacts) {
                contactListAdapter.setContacts(contacts);
            }
        });
    }

    private View.OnClickListener deleteClickListener = v -> {
        Contact contact = (Contact) v.getTag();
        contactListViewModel.deleteContact(contact);
    };

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void setupButtons() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsListActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
