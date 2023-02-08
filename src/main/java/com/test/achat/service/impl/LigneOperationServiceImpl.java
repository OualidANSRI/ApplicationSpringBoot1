package com.test.achat.service.impl;

import com.test.achat.entity.Client;
import com.test.achat.entity.LigneOperation;
import com.test.achat.entity.Operation;
import com.test.achat.repository.DAO.Impl.ILigneOperationDAO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ligneOperationService")
public class LigneOperationServiceImpl {
    @Autowired
   private ILigneOperationDAO ligneOperationDAO;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private OperationServiceImpl operationService;


    public ILigneOperationDAO getDAO() { return this.ligneOperationDAO; }


    public ClientServiceImpl getClientService() {
        return this.clientService;
    }
    public OperationServiceImpl getOperationService() {
        return this.operationService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<LigneOperation> createWithCallingServiceClientandOperation(int id, Operation operation,Client client, String statut, String assignation)
    {
        Operation op = getOperationService().create(operation);
        Client cl = getClientService().create(client);
        List<LigneOperation> listOp = new ArrayList<>();
        LigneOperation lop = new LigneOperation();
        lop.setId(id);
        lop.setOperation(op);
        lop.setClient(cl);
        lop.setStatut(statut);
        lop.setAssignation(assignation);

        lop = this.create(lop);
        listOp = this.findAll();
        return listOp;
    }
    public LigneOperation create( LigneOperation ligneOperation) {
        return this.getDAO().saveAndFlush(ligneOperation);
    }
    @CachePut(value = "ligneOperation", key ="#lp.getId()")
    public LigneOperation update(LigneOperation lp) { return this.ligneOperationDAO.saveAndFlush(lp);}
    @Cacheable(value = "ligneOperation",key ="#id")
    public Optional<LigneOperation> findById(Integer id) {
        return this.getDAO().findById(id);
    }
    @Cacheable(value ="listLigneOperation")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<LigneOperation> findAll() {
        return this.getDAO().findAll();
    }
    @CacheEvict(value ="ligneOperation", key="#id")
    public void deleteById(Integer id) { this.getDAO().deleteById(id); }
    @Caching(evict = {@CacheEvict(value = "listLigneOperation", allEntries = true), @CacheEvict(value = "ligneOperation", allEntries = true)})
    public void deleteAll() { this.getDAO().deleteAll(); }
    public long count() {
        return this.getDAO().count();
    }

}


