package com.group38;

public class IndividualCustomer<T> implements InterfaceIndividualCustomer{
    private T ID ;
    private boolean membership;
    public IndividualCustomer (T ID){
        try{
            setID(ID);
        }catch(InvalidTypeOf_ID a){
            System.out.println(a.getMessage());
            System.exit(-1);
        }catch (Invalid_IDLength e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
    @Override
    public float getDefinedDiscount() {
        return membership ? (float)0.1 : (float)0.0;
    }

    @Override
    public Object getCustomerID() {
        return ID;
    }

    @Override
    public boolean isMember() {
        return membership;
    }
    private void setID(T ID) throws Invalid_IDLength , InvalidTypeOf_ID{
        if (checkID(ID)) {
            this.ID = ID;
        }
    }
    private boolean checkID(T ID) throws Invalid_IDLength , InvalidTypeOf_ID{
        if (ID instanceof String){
            String temp = (String)ID;
            if ((temp.length() == 12) && (temp.substring(0,1).equalsIgnoreCase("M"))){
                membership = true;
                return true;
            }else{
                throw new Invalid_IDLength(12, "non member individual");
            }
        }else if (ID instanceof Long){
            Long tempInt = (Long)ID;
            if (tempInt.toString().length() == 11){
                return true;
            }else{
                throw new Invalid_IDLength(11,"member individual");
            }
        }else{
            throw new InvalidTypeOf_ID();
        }
    }
}
