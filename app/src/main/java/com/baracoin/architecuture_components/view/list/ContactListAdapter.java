package com.baracoin.architecuture_components.view.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baracoin.architecuture_components.R;
import com.baracoin.architecuture_components.entity.Contact;

import java.util.List;

/**
 * Created by PMohale on 2018/06/10.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private final Context context;
    private List<Contact> contacts;
    private View.OnClickListener deleteContactClickListener;
    private View.OnClickListener veiwContactClickListener;

    public ContactListAdapter(Context context, List<Contact> contacts, View.OnClickListener deleteContactClickListener, View.OnClickListener veiwContactClickListener) {
        this.context = context;
        this.contacts = contacts;
        this.deleteContactClickListener = deleteContactClickListener;
        this.veiwContactClickListener = veiwContactClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.getNameTextView().setText(contact.getName());
        holder.getEmailTextView().setText(contact.getEmail());
        holder.getTelephoneTextView().setText(contact.getTelephone());
        holder.itemView.setTag(contact);
        holder.getDeleteButton().setTag(contact);
        holder.getDeleteButton().setOnClickListener(deleteContactClickListener);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
