package com.baracoin.architecuture_components.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.baracoin.architecuture_components.database.dao.ContactDao;
import com.baracoin.architecuture_components.entity.Contact;

/**
 * Created by PMohale on 2018/06/10.
 */

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactManagementDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();
}
