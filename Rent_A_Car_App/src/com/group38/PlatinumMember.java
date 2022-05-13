package com.group38;

public class PlatinumMember extends CommercialCustomer{
    private static final float DEFINED_DISCOUNT = 0.3f;
    private static final membershipType type = membershipType.PLATINUM;

    public PlatinumMember(String ID) {
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
        if (initial == 'P'){
            return true;
        }else{
            return false;
        }
    }
}
