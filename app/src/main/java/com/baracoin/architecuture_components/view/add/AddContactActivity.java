package com.baracoin.architecuture_components.view.add;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.baracoin.architecuture_components.R;
import com.baracoin.architecuture_components.entity.Contact;
import com.baracoin.architecuture_components.injection.ContactsManagerViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddContactActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextTelephone;
    private Button buttonSave;
    @Inject
    ContactsManagerViewModelFactory contactsManagerViewModelFactory;
    private AddContactViewModel addContactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        setupViewModel();
        setupEditTexts();
        setupButton();
    }

    private void setupButton() {
        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContactViewModel.addContact(constructContact());
            }
        });
    }

    private void setupViewModel() {
        addContactViewModel = ViewModelProviders.of(this, contactsManagerViewModelFactory).get(AddContactViewModel.class);
    }

    private void setupEditTexts() {
        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextTelephone = findViewById(R.id.edit_text_telephone);
    }

    private Contact constructContact() {
        return new Contact(editTextName.getText().toString(), editTextEmail.getText().toString(), editTextTelephone.getText().toString());
    }
}
