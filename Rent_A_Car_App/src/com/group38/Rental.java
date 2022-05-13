package com.group38;

public interface Rental {
    public float calculateRentalPrice();
    public int getRentalCode();
    public boolean setRentalCode(int code);
    public Customer getCustomer();
}
