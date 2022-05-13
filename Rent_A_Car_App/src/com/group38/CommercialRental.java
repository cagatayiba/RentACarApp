package com.group38;

public class CommercialRental extends AbstractRental {
    private ICommercialCustomer customer ;
    private int numberOfMonths ;

    public CommercialRental(Car car, ICommercialCustomer customer, int numberOfMonths) {
        super(car);
        this.customer = customer;
        this.numberOfMonths = numberOfMonths;
    }

    @Override
    public float calculateRentalPrice() {
        return super.calculateRentalPrice() * 30 * numberOfMonths * (1 - customer.getDefinedDiscount());
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }


    public String toString(){
        return super.toString().substring(0,20) + String.format("%-20s",customer.getCustomerID()) +
                String.format("%-20s",customer.getMemberShipType().toString()) +String.format("%-20s",getNumberOfMonths())
                + super.toString().substring(20) ;
    }

    public int getNumberOfMonths(){
        return numberOfMonths;
    }
}
