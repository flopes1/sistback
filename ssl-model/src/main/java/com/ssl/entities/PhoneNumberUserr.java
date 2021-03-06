package com.ssl.entities;
// Generated 28/02/2017 11:05:58 by Hibernate Tools 5.2.1.Final

/**
 * PhoneNumberUserr generated by hbm2java
 */
public class PhoneNumberUserr implements java.io.Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -3457357098459163556L;
    
    private int id;
    private Userr userr;
    private short countryCode;
    private short stateCode;
    private int number;

    public PhoneNumberUserr()
    {
    }

    public PhoneNumberUserr(int id, short countryCode, short stateCode, int number)
    {
        this.id = id;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumberUserr(int id, Userr userr, short countryCode, short stateCode, int number)
    {
        this.id = id;
        this.userr = userr;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Userr getUserr()
    {
        return this.userr;
    }

    public void setUserr(Userr userr)
    {
        this.userr = userr;
    }

    public short getCountryCode()
    {
        return this.countryCode;
    }

    public void setCountryCode(short countryCode)
    {
        this.countryCode = countryCode;
    }

    public short getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(short stateCode)
    {
        this.stateCode = stateCode;
    }

    public int getNumber()
    {
        return this.number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

}
