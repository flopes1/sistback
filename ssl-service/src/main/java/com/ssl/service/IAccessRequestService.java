package com.ssl.service;

import java.util.List;

import com.ssl.entities.AccessRequest;
import com.ssl.entities.request.EvaluateAccessRequestResponse;

public interface IAccessRequestService
{

    void addAccessRequest(AccessRequest accessRequest);

    AccessRequest getAccessRequestById(int accessRequetId);

    List<AccessRequest> getAllAccessRequest();

    AccessRequest updateAccessRequest(AccessRequest accessRequest);

    void removeAccessRequest(AccessRequest accessRequest);

    void removeAccessRequestById(int accessRequetId);

    void requestAccess(AccessRequest accessRequest);

    void evaluateAccessRequest(EvaluateAccessRequestResponse response);

}
