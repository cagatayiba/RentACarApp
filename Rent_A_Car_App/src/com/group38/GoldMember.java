package com.group38;

public class GoldMember extends CommercialCustomer{
    private static final float DEFINED_DISCOUNT = 0.25f;
    public static final membershipType type = membershipType.GOLD;

    public GoldMember(String ID){
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
        if (initial == 'G'){
            return true;
        }else{
            return false;
        }
    }
}
