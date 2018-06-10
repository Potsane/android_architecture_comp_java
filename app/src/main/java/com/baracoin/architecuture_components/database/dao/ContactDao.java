package com.baracoin.architecuture_components.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

/**
 * Created by PMohale on 2018/06/10.
 */
@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addContact(Contact contact);

    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> getAllContacts();

    @Delete
    void deleteContact(Contact contact);
}
