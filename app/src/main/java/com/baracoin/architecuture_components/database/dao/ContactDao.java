package com.baracoin.architecuture_components.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

/**
 * Created by PMohale on 2018/06/10.
 */

public interface ContactDao {

    @Insert
    void addContact(Contact contact);

    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> getAllContacts();

    @Query("DELETE FROM contact WHERE id = :id")
    void deleteContact(long id);
}
