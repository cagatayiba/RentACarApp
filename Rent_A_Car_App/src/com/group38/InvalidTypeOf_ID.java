package com.group38;

public class InvalidTypeOf_ID extends Exception{
    public InvalidTypeOf_ID(){
        super ("For individual customers type of id must be String or 11 digit integer (Long)");
    }
    public InvalidTypeOf_ID(String m){
        super(m);
    }
}
