package com.group38;

public class Invalid_IDLength extends Exception{
    public Invalid_IDLength(){
        super ("ID length is not valid!");
    }
    public Invalid_IDLength(int valid , String customerType){
        super ("ID length is not valid!" + "It must be : " + valid + " for " + customerType + " customers" );
    }
    public Invalid_IDLength(String message){
        super (message);
    }
}
