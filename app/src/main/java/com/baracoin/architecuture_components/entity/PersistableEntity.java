package com.baracoin.architecuture_components.entity;

import android.arch.persistence.room.PrimaryKey;

/**
 * Created by PMohale on 2018/06/10.
 */

public abstract class PersistableEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
