package com.gamecodeschool.dualfragments;

import java.io.Serializable;

// We implement Serializable as this is required by ArrayAdapter
public class NameAndAddress implements Serializable{
    private String mName;
    private String mAddress1;
    private String mAddress2;
    private String mZipCode;

    public NameAndAddress(String name,
                          String address1,
                          String address2,
                          String zipCode){
        mName = name;
        mAddress1 = address1;
        mAddress2 = address2;
        mZipCode = zipCode;
    }

    public String getName() {
        return mName;
    }



    public String getAddress1() {
        return mAddress1;
    }



    public String getAddress2() {
        return mAddress2;
    }



    public String getZipCode() {
        return mZipCode;
    }


}
