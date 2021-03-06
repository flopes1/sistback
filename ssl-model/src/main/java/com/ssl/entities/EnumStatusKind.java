package com.ssl.entities;
// Generated 28/02/2017 11:05:58 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * EnumStatusKind generated by hbm2java
 */
public class EnumStatusKind implements java.io.Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -970347345401780003L;
    
    private int id;
    private String name;
    private Set<ScheduledVisit> scheduledVisits = new HashSet<ScheduledVisit>(0);

    public EnumStatusKind()
    {
    }

    public EnumStatusKind(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public EnumStatusKind(int id, String name, Set<ScheduledVisit> scheduledVisits)
    {
        this.id = id;
        this.name = name;
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
