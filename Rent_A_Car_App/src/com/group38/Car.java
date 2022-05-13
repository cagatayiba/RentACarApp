package com.group38;

public class Car {
    private String model ;
    private int year ;
    private float basePrice ;

    public Car(String model, int year, float basePrice) {
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getBasePrice() {
        return basePrice;
    }
    public float getModelYearRatio(){
        if (getYear() > 2021){
            return 1f;
        }else if((2020 <= getYear()) && (getYear() <= 2021) ){
            return 0.95f;
        }else if((2017 <= getYear()) && (getYear() <= 2019)) {
            return 0.9f;
        }else{
            System.out.println("There shouldn't be a car with a model year before 2017." ); // exception gelecek
            return 0.0f;
        }

    }
}
