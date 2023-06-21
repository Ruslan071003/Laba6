package com.example.myfriendofmisery;

public class Big extends Package {
    private final double weight;

    public Big(double weight) {
        super("Large", false, "Car needed");
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
