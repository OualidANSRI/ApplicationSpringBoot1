package com.test.achat.service.impl;

import com.test.achat.entity.Operation;
import com.test.achat.repository.DAO.Impl.IOperationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// @Transactional
@Service("operationService")
public class OperationServiceImpl {
    @Autowired
    IOperationDAO operationDAO;


    public IOperationDAO getDAO() {
        return this.operationDAO;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Operation create( Operation operation) {
        return this.getDAO().save(operation);
    }
    public Operation update(Operation operation) {
        return this.getDAO().saveAndFlush(operation);
    }
    public Optional<Operation> findById(int id) {
        return operationDAO.findById(id);
    }
    public List<Operation> findAll() {
        return this.getDAO().findAll();
    }
    public void deleteById(Integer id) {
        this.getDAO().deleteById(id);
    }

    public void deleteAll() {
        this.getDAO().deleteAll();
    }
    public long count() {
        return this.getDAO().count();
    }

}

