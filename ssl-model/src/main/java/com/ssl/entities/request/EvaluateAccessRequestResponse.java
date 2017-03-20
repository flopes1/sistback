package com.ssl.entities.request;

import java.io.Serializable;
import java.util.Date;

import com.ssl.entities.AccessRequest;
import com.ssl.entities.Employee;

public class EvaluateAccessRequestResponse implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -5235035901924182506L;

    private AccessRequest accessRequest;
    private Employee employee;
    private Boolean accepted;
    private String reason;
    private Date date;

    public EvaluateAccessRequestResponse()
    {
    }

    public AccessRequest getAccessRequest()
    {
        return accessRequest;
    }

    public void setAccessRequest(AccessRequest accessRequest)
    {
        this.accessRequest = accessRequest;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public Boolean getAccepted()
    {
        return accepted;
    }

    public void setAccepted(Boolean accepted)
    {
        this.accepted = accepted;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

}
