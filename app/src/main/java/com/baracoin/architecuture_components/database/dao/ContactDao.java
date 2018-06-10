package com.baracoin.architecuture_components.database.dao;

import android.arch.persistence.room.Insert;

import com.baracoin.architecuture_components.entity.Contact;

/**
 * Created by PMohale on 2018/06/10.
 */

public interface ContactDao {

    @Insert
    void addContact(Contact contact);
}
