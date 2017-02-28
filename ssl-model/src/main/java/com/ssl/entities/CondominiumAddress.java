package com.ssl.entities;
// Generated 28/02/2017 11:05:58 by Hibernate Tools 5.2.1.Final

/**
 * CondominiumAddress generated by hbm2java
 */
public class CondominiumAddress implements java.io.Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -3220932146190126402L;
    
    private int id;
    private Condominium condominium;
    private String street;
    private int number;
    private String district;
    private String state;
    private String city;
    private int zipCode;
    private String country;

    public CondominiumAddress()
    {
    }

    public CondominiumAddress(int id, String street, int number, String district, String state, String city,
            int zipCode, String country)
    {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public CondominiumAddress(int id, Condominium condominium, String street, int number, String district, String state,
            String city, int zipCode, String country)
    {
        this.id = id;
        this.condominium = condominium;
        this.street = street;
        this.number = number;
        this.district = district;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Condominium getCondominium()
    {
        return this.condominium;
    }

    public void setCondominium(Condominium condominium)
    {
        this.condominium = condominium;
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getNumber()
    {
        return this.number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getDistrict()
    {
        return this.district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return this.zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

}
