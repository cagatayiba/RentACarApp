package com.group38;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileIO data  = new FileIO("HW4_Rentals.csv");
        RentalCompany company = new RentalCompany();
        company.setAllRentals(data.getLines());
        company.generateCodes();
        company.displayExtendedOutline();
    }
}

