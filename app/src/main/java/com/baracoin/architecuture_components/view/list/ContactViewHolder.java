package com.baracoin.architecuture_components.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baracoin.architecuture_components.R;

/**
 * Created by PMohale on 2018/06/10.
 */

class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView emailTextView;
    private TextView telephoneTextView;
    private Button deleteButton;

    public ContactViewHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.text_view_name);
        emailTextView = (TextView) itemView.findViewById(R.id.text_view_email);
        telephoneTextView = (TextView) itemView.findViewById(R.id.text_view_telephone);
        deleteButton = (Button) itemView.findViewById(R.id.button_delete);
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.nameTextView = nameTextView;
    }

    public TextView getEmailTextView() {
        return emailTextView;
    }

    public void setEmailTextView(TextView emailTextView) {
        this.emailTextView = emailTextView;
    }

    public TextView getTelephoneTextView() {
        return telephoneTextView;
    }

    public void setTelephoneTextView(TextView telephoneTextView) {
        this.telephoneTextView = telephoneTextView;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }
}
