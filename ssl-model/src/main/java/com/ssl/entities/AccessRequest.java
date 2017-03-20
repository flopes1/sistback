package com.ssl.entities;

//default package

//Generated 28/02/2017 22:40:44 by Hibernate Tools 5.2.1.Final

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * AccessRequest generated by hbm2java
 */
@Entity
@Table(name = "access_request", schema = "dbo")
@DynamicInsert
@DynamicUpdate
public class AccessRequest implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -2232568265637945854L;

    private int id;
    private Condominium condominium;
    private Userr userr;
    private Date requestDate;

    public AccessRequest()
    {
    }

    public AccessRequest(int id, Date requestDate)
    {
        this.id = id;
        this.requestDate = requestDate;
    }

    public AccessRequest(int id, Condominium condominium, Userr userr, Date requestDate)
    {
        this.id = id;
        this.requestDate = requestDate;
        this.condominium = condominium;
        this.userr = userr;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condominium_id")
    public Condominium getCondominium()
    {
        return this.condominium;
    }

    public void setCondominium(Condominium condominium)
    {
        this.condominium = condominium;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userr_id")
    public Userr getUserr()
    {
        return this.userr;
    }

    public void setUserr(Userr userr)
    {
        this.userr = userr;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date", nullable = false)
    public Date getDate()
    {
        return this.requestDate;
    }

    public void setDate(Date requestDate)
    {
        this.requestDate = requestDate;
    }

}