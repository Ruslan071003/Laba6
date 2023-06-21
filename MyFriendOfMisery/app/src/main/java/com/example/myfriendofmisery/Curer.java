package com.example.myfriendofmisery;

import java.util.ArrayList;

public class Curer {
    private final String fullName;
    private final String currentAccount;
    private final boolean hasOwnCar;
    private final boolean canDeliverDocuments;
    private final ArrayList<Order> orders;

    public Curer(String fullName, String currentAccount, boolean hasOwnCar, boolean canDeliverDocuments) {
        this.fullName = fullName;
        this.currentAccount = currentAccount;
        this.hasOwnCar = hasOwnCar;
        this.canDeliverDocuments = canDeliverDocuments;
        this.orders = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public boolean hasOwnCar() {
        return hasOwnCar;
    }

    public boolean canDeliverDocuments() {
        return canDeliverDocuments;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
