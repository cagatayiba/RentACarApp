package com.group38;

public class IndividualRental extends AbstractRental{
    private InterfaceIndividualCustomer customer ;
    private int numberOfDays;

    public IndividualRental(Car car, InterfaceIndividualCustomer customer, int numberOfDays) {
        super(car);
        this.customer = customer;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public float calculateRentalPrice() {
        return super.calculateRentalPrice() * numberOfDays * (1 - customer.getDefinedDiscount());
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }


    public String toString(){
        return super.toString().substring(0,20) + String.format("%-20s",customer.getCustomerID()) +
                String.format("%-20s",(customer.isMember() ? "Yes"  : "No")) + String.format("%-20s",getNumberOfDays())
                + super.toString().substring(20) ;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}
