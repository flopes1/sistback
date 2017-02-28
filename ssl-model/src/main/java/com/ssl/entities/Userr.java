package com.ssl.entities;
// Generated 28/02/2017 11:05:58 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Userr generated by hbm2java
 */
public class Userr implements java.io.Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 4405068494476518897L;
    
    private int id;
    private Condominium condominium;
    private int cpf;
    private String email;
    private String apartmentIdentifier;
    private Set<AutenticationHistory> autenticationHistories = new HashSet<AutenticationHistory>(0);
    private Set<Vehicle> vehicles = new HashSet<Vehicle>(0);
    private Set<PhoneNumberUserr> phoneNumberUserrs = new HashSet<PhoneNumberUserr>(0);
    private Set<ScheduledVisit> scheduledVisits = new HashSet<ScheduledVisit>(0);

    public Userr()
    {
    }

    public Userr(int id, int cpf, String email, String apartmentIdentifier)
    {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.apartmentIdentifier = apartmentIdentifier;
    }

    public Userr(int id, Condominium condominium, int cpf, String email, String apartmentIdentifier,
            Set<AutenticationHistory> autenticationHistories, Set<Vehicle> vehicles,
            Set<PhoneNumberUserr> phoneNumberUserrs, Set<ScheduledVisit> scheduledVisits)
    {
        this.id = id;
        this.condominium = condominium;
        this.cpf = cpf;
        this.email = email;
        this.apartmentIdentifier = apartmentIdentifier;
        this.autenticationHistories = autenticationHistories;
        this.vehicles = vehicles;
        this.phoneNumberUserrs = phoneNumberUserrs;
        this.scheduledVisits = scheduledVisits;
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

    public int getCpf()
    {
        return this.cpf;
    }

    public void setCpf(int cpf)
    {
        this.cpf = cpf;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getApartmentIdentifier()
    {
        return this.apartmentIdentifier;
    }

    public void setApartmentIdentifier(String apartmentIdentifier)
    {
        this.apartmentIdentifier = apartmentIdentifier;
    }

    public Set<AutenticationHistory> getAutenticationHistories()
    {
        return this.autenticationHistories;
    }

    public void setAutenticationHistories(Set<AutenticationHistory> autenticationHistories)
    {
        this.autenticationHistories = autenticationHistories;
    }

    public Set<Vehicle> getVehicles()
    {
        return this.vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }

    public Set<PhoneNumberUserr> getPhoneNumberUserrs()
    {
        return this.phoneNumberUserrs;
    }

    public void setPhoneNumberUserrs(Set<PhoneNumberUserr> phoneNumberUserrs)
    {
        this.phoneNumberUserrs = phoneNumberUserrs;
    }

    public Set<ScheduledVisit> getScheduledVisits()
    {
        return this.scheduledVisits;
    }

    public void setScheduledVisits(Set<ScheduledVisit> scheduledVisits)
    {
        this.scheduledVisits = scheduledVisits;
    }

}
