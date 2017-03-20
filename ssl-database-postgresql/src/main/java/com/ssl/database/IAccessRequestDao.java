package com.ssl.database;

import java.util.List;

import com.ssl.entities.AccessRequest;

public interface IAccessRequestDao
{

    void addAccessRequest(AccessRequest accessRequest);

    AccessRequest getAccessRequestById(int accessRequetId);

    List<AccessRequest> getAllAccessRequest();

    AccessRequest updateAccessRequest(AccessRequest accessRequest);

    void removeAccessRequest(AccessRequest accessRequest);

    void removeAccessRequestById(int accessRequetId);

}
