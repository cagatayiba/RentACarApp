package com.group38;

public abstract class AbstractRental implements Rental{
    private Car rentalCar ;
    private int code ;
    public AbstractRental( Car car){
        this.rentalCar = car;
    }
    public float calculateRentalPrice( ){
        return rentalCar.getBasePrice() * rentalCar.getModelYearRatio();
    }

    public abstract Customer getCustomer();

    public int getRentalCode() {
        return code;
    }

    public boolean setRentalCode(int code) {
        if ((999999 < code) && (code<10000000)){
            this.code = code;
            return true;
        }else{
            System.out.println("code is not valid"); // exception gelecek
            return false;
        }

    }
    public String toString(){
        return String.format("%-20s",Integer.toString(code))  +String.format("%-20s", rentalCar.getModel()) +
                String.format("%-20s", rentalCar.getYear()) + String.format("%-20s" , calculateRentalPrice());
    }
}
