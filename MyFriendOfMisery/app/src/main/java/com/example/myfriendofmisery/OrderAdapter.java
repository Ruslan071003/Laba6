package com.example.myfriendofmisery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter<Order> {
    private final Context context;
    private final int resource;
    private  ArrayList<Order> orders;

    public OrderAdapter(Context context, int resource, ArrayList<Order> orders) {
        super(context, resource, orders);
        this.context = context;
        this.resource = resource;
        this.orders = orders;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }

        Order order = orders.get(position);


        TextView companyTextView = convertView.findViewById(R.id.companyTextView);
        TextView packageTypeTextView = convertView.findViewById(R.id.packageTypeTextView);
        TextView senderAddressTextView = convertView.findViewById(R.id.senderAddressTextView);
        TextView recipientAddressTextView = convertView.findViewById(R.id.recipientAddressTextView);
        TextView priceTextView = convertView.findViewById(R.id.priceTextView);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);

        companyTextView.setText(order.getFirm().getName());
        packageTypeTextView.setText(order.getPackage().getClass().getSimpleName());
        senderAddressTextView.setText(order.getPickupAddress());
        recipientAddressTextView.setText(order.getDeliveryAddress());
        priceTextView.setText(String.valueOf(order.getPrice()));
        checkBox.setChecked(false);

        return convertView;
    }


}
