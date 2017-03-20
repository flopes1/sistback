package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.database.IAccessRequestDao;
import com.ssl.entities.AccessRequest;
import com.ssl.entities.AutenticationHistory;
import com.ssl.entities.request.EvaluateAccessRequestResponse;
import com.ssl.service.IAccessRequestService;
import com.ssl.service.IAutenticationHistoryService;

@Component
@Transactional
public class AccessRequestService implements IAccessRequestService
{

    private static final Logger log = LoggerFactory.getLogger(AccessRequestService.class);

    @Autowired
    private IAccessRequestDao accessRequestDao;

    @Autowired
    private IAutenticationHistoryService autenticationHistoryService;

    @Override
    public void requestAccess(AccessRequest accessRequest)
    {
        log.debug("Requesting access to condominium: " + accessRequest.getCondominium().getName() + " to user: "
                + accessRequest.getUserr().getName());

        this.addAccessRequest(accessRequest);

        log.debug("Requesting access added with success, wating for approval");

    }

    @Override
    public void evaluateAccessRequest(EvaluateAccessRequestResponse response)
    {
        log.debug("Evaluating access to condominium: " + response.getAccessRequest().getCondominium().getId()
                + " to user: " + response.getAccessRequest().getUserr().getId() + " performed by employee: "
                + response.getEmployee().getId() + " ...");

        String result = response.getAccepted() ? "Approved " : "Disapproved";

        log.debug("Access " + result + " in " + response.getDate());

        log.debug("Removing access request after evaluating");

        this.accessRequestDao.removeAccessRequest(response.getAccessRequest());

        log.debug("Saving operation in autentication history");

        AutenticationHistory autenticationHistory = new AutenticationHistory();
        autenticationHistory.setCondominium(response.getAccessRequest().getCondominium());
        autenticationHistory.setAccepted(response.getAccepted());
        autenticationHistory.setDate(response.getDate());
        autenticationHistory.setEmployee(response.getEmployee());
        autenticationHistory.setReason(response.getReason());
        autenticationHistory.setUserr(response.getAccessRequest().getUserr());

        this.autenticationHistoryService.addAutenticationHistory(autenticationHistory);

        log.debug("Operation saved");

    }

    @Override
    public void addAccessRequest(AccessRequest accessRequest)
    {
        this.accessRequestDao.addAccessRequest(accessRequest);
    }

    @Override
    public AccessRequest getAccessRequestById(int accessRequetId)
    {
        return this.accessRequestDao.getAccessRequestById(accessRequetId);
    }

    @Override
    public List<AccessRequest> getAllAccessRequest()
    {
        return this.accessRequestDao.getAllAccessRequest();
    }

    @Override
    public AccessRequest updateAccessRequest(AccessRequest accessRequest)
    {
        return this.accessRequestDao.updateAccessRequest(accessRequest);
    }

    @Override
    public void removeAccessRequest(AccessRequest accessRequest)
    {
        this.accessRequestDao.removeAccessRequest(accessRequest);
    }

    @Override
    public void removeAccessRequestById(int accessRequetId)
    {
        this.accessRequestDao.removeAccessRequestById(accessRequetId);
    }

}
