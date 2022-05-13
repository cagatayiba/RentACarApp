package com.group38;

import java.util.*;

public class RentalCompany {
    private List<Rental> commercialRentals ;
    private List<Rental> individualRentals ;
    private Set<Integer> codes;
    public RentalCompany(){
        commercialRentals = new ArrayList<Rental>(50);
        individualRentals = new ArrayList<Rental>(50);
        codes = new HashSet<Integer>();
    }
    public void setAllRentals (List <String> given){
        StringTokenizer tokenizer = null;
        String indicator = null;
        Car car = null;
        InterfaceIndividualCustomer individualCustomer = null;
        ICommercialCustomer commercialCustomer = null;
        Rental rental = null;
        for (String token : given){
            tokenizer = new StringTokenizer(token, "\n,");
            indicator = tokenizer.nextToken();
            if (indicator.equalsIgnoreCase("Individual")){
                rental = createIndividualRental(tokenizer);
                if (rental != null){
                    individualRentals.add(rental);
                }
            }else if (indicator.equalsIgnoreCase("Commercial")){
                rental = createCommercialRental(tokenizer);
                commercialRentals.add(rental);
            }else{
                System.out.printf("a rental must be individual or commercial hence the entry data ( '%s' ) is not valid %n", indicator);
            }
        }
    }
    public void generateCodes(){
        int min = 1000000;
        int max = 9999999;
        generateCodeForRentals(commercialRentals, max, min);
        generateCodeForRentals(individualRentals, max, min);
    }
    public void displayIndividualRentals( ){
        int count = 1;
        for (Rental token : individualRentals){
            System.out.printf("%-20d%s%n", count , token.toString());
            count++;
        }

    }
    public void displayCommercialRentals( ){
        int count = 1;
        for (Rental token : commercialRentals){
            System.out.printf("%-20d%s%n", count , token.toString());
            count++;
        }

    }
    public void displayOutline( ){
        System.out.println("Welcome!");
        System.out.printf("Total number of cars rented: %d%n" , getNumberOfCarsRented());
        System.out.printf("Total number of commercial rentals: %d%n", getNumberOfCommercialRentals());
        System.out.printf("Total number of commercial rental-month: %d%n", getNumberOfCommercialRentalMonth());
        System.out.printf("Total number of individual rentals: %d%n", getNumberOfIndividualRentals());
        System.out.printf("Total number of individual rental-day: %d%n",getNumberOfIndividualRentalDay() );
        System.out.printf("Total number of rentals of individual non-member customers: %d%n", getNumberOfRentalsOfIndividualNonMemberCustomers());
        System.out.printf("Total number of rentals of individual member customers : %d%n", getNumberOfRentalsOfIndividualMemberCustomers());
        System.out.printf("Total number of rentals of silver commercial customers: %d%n", getNumberOfRentalsOfSilverCustomers());
        System.out.printf("Total number of rentals of gold commercial customers: %d%n", getNumberOfRentalsOfGoldCustomers());
        System.out.printf("Total number of rentals of platinum commercial customers: %d%n", getNumberOfRentalsOfPlatinumCustomers());
    }
    public void displayExtendedOutline( ){
        displayOutline();
        System.out.println();
        System.out.println("Individual Rentals");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "No", "Rental Code", "Customer ID", "isMember",
                "Number of Days", "Car Model" , "Model Year", "Rental Price");
        displayIndividualRentals();
        System.out.println();
        System.out.println("Commercial Rentals");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "No", "Rental Code", "Customer ID", " Customer Type",
                "Number of Months", "Car Model" , "Model Year", "Rental Price");
        displayCommercialRentals();

    }
    public int getNumberOfCarsRented( ){
        return commercialRentals.size() + individualRentals.size();

    }
    public int getNumberOfCommercialRentals ( ){
        return commercialRentals.size();
    }
    public int getNumberOfCommercialRentalMonth ( ){
        int sum = 0;
        CommercialRental temp ;
        for (Rental token : commercialRentals){
            temp = (CommercialRental) token;
            sum += temp.getNumberOfMonths();
        }
        return sum;
    }
    public int getNumberOfIndividualRentals(){
        return individualRentals.size();
    }
    public int getNumberOfIndividualRentalDay(){
        int sum = 0;
        IndividualRental temp;
        for (Rental token : individualRentals){
            temp = (IndividualRental) token;
            sum += temp.getNumberOfDays();
        }
        return sum;
    }
    public int getNumberOfRentalsOfIndividualNonMemberCustomers(){
        return getNumberOfIndividualRentals() - getNumberOfRentalsOfIndividualMemberCustomers();
    }
    public int getNumberOfRentalsOfIndividualMemberCustomers( ){
        int sum = 0 ;
        IndividualRental temp;
        IndividualCustomer customer;
        for (Rental token : individualRentals){
            temp = (IndividualRental) token;
            customer = (IndividualCustomer)temp.getCustomer();
            if (customer.isMember()){
                sum++;
            }
        }
        return sum;
    }
    public int getNumberOfRentalsOfSilverCustomers( ){
        return findNumberOfMembershipType(membershipType.SILVER);
    }
    public int getNumberOfRentalsOfGoldCustomers( ){
        return findNumberOfMembershipType(membershipType.GOLD);
    }
    public int getNumberOfRentalsOfPlatinumCustomers( ){
        return findNumberOfMembershipType(membershipType.PLATINUM);
    }
    private Rental createIndividualRental(StringTokenizer tokenizer){

        InterfaceIndividualCustomer customer = createIndividualCustomer(tokenizer.nextToken());
        int numberOfDays = Integer.parseInt(tokenizer.nextToken());
        Car car =  createCar(tokenizer);
        Rental returned =  new IndividualRental(car, customer, numberOfDays);
        return returned;
    }
    private Rental createCommercialRental(StringTokenizer tokenizer){
        ICommercialCustomer customer = createCommercialCustomer(tokenizer.nextToken());
        int numberOfMonths = Integer.parseInt(tokenizer.nextToken());
        Car car = createCar(tokenizer);
        Rental returned = new CommercialRental(car , customer, numberOfMonths);
        return returned;
    }
    private Car createCar(StringTokenizer tokenizer){
        Car car = new Car(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()), Float.parseFloat(tokenizer.nextToken()) );
        return car;
    }
    private InterfaceIndividualCustomer createIndividualCustomer(String ID){
        char indicator = ID.charAt(0);
        if (indicator == 'M'){
            return new IndividualCustomer<>(ID);
        }else if ( (48 <= indicator) && (indicator <= 57)){
            return new IndividualCustomer<>(Long.parseLong(ID));
        }else{
            System.out.printf("for individual customers initial letter of the id must be 'M' or a digit thus customer cannot be created with this id: %s" , ID);
            return null;
        }
    }
    private ICommercialCustomer createCommercialCustomer(String ID){
        ICommercialCustomer customer = null;
        char indicator  = ID.charAt(0);
        switch (indicator){
            case ('S'):
                customer = new SilverMember(ID);
                break;
            case ('G'):
                customer = new GoldMember(ID);
                break;
            case ('P'):
                customer = new PlatinumMember(ID);
                break;
        }
        if (customer == null){
            System.out.printf("commercial customer cannot be created with id of %s%n", ID);
            System.out.println("initial letter of the id of the customer is not valid");
        }
        return customer;

    }
    private void generateCodeForRentals(List<Rental> list , int max, int min){
        int code = 0;
        boolean flag = false;
        for (Rental token : list){
            flag = false;
            while (!flag){
                code = (int)Math.floor(Math.random()*(max-min+1)+min);
                flag = codes.add(code);
            }
            token.setRentalCode(code);
        }
    }

    private int findNumberOfMembershipType(membershipType type){
        int sum = 0;
        ICommercialCustomer customer ;
        for(Rental token : commercialRentals){
            customer = (ICommercialCustomer) token.getCustomer();
            if (customer.getMemberShipType() == type){
                sum++;
            }
        }
        return sum;

    }



}
