package com.example.myfriendofmisery;

import java.util.Date;

public class Order {
    private final Firm firm;
    private final Package packageItem;
    private final String pickupAddress;
    private final String deliveryAddress;
    private final double price;

    private final Date expirationDate;

    public Order(Firm firm, Package packageItem, String pickupAddress, String deliveryAddress, double price, Date expirationDate) {
        this.firm = firm;
        this.packageItem = packageItem;
        this.pickupAddress = pickupAddress;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public Firm getFirm() {
        return firm;
    }

    public Package getPackage() {
        return packageItem;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getPrice() {
        return price;
    }

    public long getExpirationDate() {
        return expirationDate.getTime();
    }
}
