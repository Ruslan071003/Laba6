package com.example.myfriendofmisery;

public abstract class Package {
    private final String size;
    private final boolean brittle;
    private final String transportationRequirements;

    public Package(String size, boolean brittle, String transportationRequirements) {
        this.size = size;
        this.brittle = brittle;
        this.transportationRequirements = transportationRequirements;
    }

    public String getSize() {
        return size;
    }

    public boolean isBrittle() {
        return brittle;
    }

    public String getTransportationRequirements() {
        return transportationRequirements;
    }
}
