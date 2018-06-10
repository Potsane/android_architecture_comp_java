package com.baracoin.architecuture_components.entity;

import android.arch.persistence.room.Entity;

/**
 * Created by PMohale on 2018/06/10.
 */

@Entity(tableName = "contact")
public class Contact extends  PersistableEntity{

    private String name;
    private String email;
    private String telephone;

    public Contact() {
    }

    public Contact(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
