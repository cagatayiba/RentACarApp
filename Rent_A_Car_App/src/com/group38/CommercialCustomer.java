package com.group38;

public abstract class CommercialCustomer implements ICommercialCustomer{
    private String ID ;

    public CommercialCustomer(String ID) {
        try{
            setID(ID);
        }catch(Invalid_IDLength e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

    }


    @Override
    public abstract float getDefinedDiscount() ;

    @Override
    public abstract membershipType getMemberShipType();

    @Override
    public Object getCustomerID() {
        return  ID;
    }

    private void setID(String ID) throws Invalid_IDLength{
        if(ID.length() == 8){
            if (checkID(ID)){
                this.ID = ID;
            }else{
                System.out.println("invalid initial");
            }
        }else{
            throw new Invalid_IDLength(8,"CommercialCustomer");
        }
    }
    protected abstract boolean checkID(String ID);
}
