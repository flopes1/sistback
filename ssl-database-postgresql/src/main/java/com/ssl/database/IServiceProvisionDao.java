package com.ssl.database;

import com.ssl.entities.ServiceProvision;

public interface IServiceProvisionDao
{

    void addServiceProvision(ServiceProvision serviceProvision);

    ServiceProvision getServiceProvisionById(int id);

    ServiceProvision getServiceProvisionByScheduledVisitId(int scheduledVisitId);

    ServiceProvision updateServiceProvision(ServiceProvision serviceProvision);

    void removeServiceProvision(ServiceProvision serviceProvision);

    void removeServiceProvisionById(int id);

    void removeServiceProvisionByScheduledVisitId(int scheduledVisitId);

}
