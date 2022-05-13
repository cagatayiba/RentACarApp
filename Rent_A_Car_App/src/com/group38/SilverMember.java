package com.group38;

public class SilverMember extends CommercialCustomer{
    private static final float DEFINED_DISCOUNT = 0.2f;
    public static final membershipType type = membershipType.SILVER;

    public SilverMember(String ID){
        super(ID);
    }

    @Override
    public float getDefinedDiscount() {
        return DEFINED_DISCOUNT;
    }

    @Override
    public membershipType getMemberShipType() {
        return type;
    }

    @Override
    protected boolean checkID(String ID) {
        char initial = ID.charAt(0);
        if (initial == 'S'){
            return true;
        }else{
            return false;
        }
    }


}
