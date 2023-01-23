package com.test.achat.service.impl;

import com.test.achat.entity.LigneOperation;
import com.test.achat.repository.DAO.Impl.ILigneOperationDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service("LigneOperationService")
public class LigneOperationServiceImpl implements ILigneOperationDAO {

    @Autowired
    ILigneOperationDAO ligneOperationDAO;


    public LigneOperation update(LigneOperation lp) {

            return this.ligneOperationDAO.saveAndFlush(lp);
    }

    public ILigneOperationDAO getDAO() {
        // TODO Auto-generated method stub
        return this.ligneOperationDAO;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends LigneOperation> S saveAndFlush(S entity) {
        return this.getDAO().saveAndFlush(entity);
    }

    @Override
    public <S extends LigneOperation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<LigneOperation> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public LigneOperation getOne(Integer integer) {
        return null;
    }

    public LigneOperation create( LigneOperation ligneOperation) {
        return this.getDAO().save(ligneOperation);
    }

    @Override
    public LigneOperation getById(Integer id) {
        return this.getDAO().getById(id);
    }

    @Override
    public LigneOperation getReferenceById(Integer integer) {
        return null;
    }


    @Override
    public <S extends LigneOperation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends LigneOperation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LigneOperation> long count(Example<S> example) {
        return 0;
    }


    @Override
    public <S extends LigneOperation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends LigneOperation> Optional<S> findOne(Example<S> ligneOperation) {
        return Optional.empty();
    }

    @Override
    //@Transactional
    public <S extends LigneOperation> List<S> findAll(Example<S> ligneOperation) {
        return this.getDAO().findAll(ligneOperation);
    }

    @Override
    public <S extends LigneOperation> boolean exists(Example<S> ligneOperation) {
        return this.getDAO().exists(ligneOperation);
    }


    @Override
    public <S extends LigneOperation> S save(S entity) {
        return this.getDAO().save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return this.getDAO().existsById(id);
    }

    @Override
    public <S extends LigneOperation> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LigneOperation> findById(Integer integer) {
        return Optional.empty();
    }


    @Override
    public List<LigneOperation> findAll() {
        return this.getDAO().findAll();
    }

    @Override
    public List<LigneOperation> findAllById(Iterable<Integer> ids) {
        return this.getDAO().findAllById(ids);
    }

    @Override
    public long count() {
        return this.getDAO().count();
    }

    @Override
    public void deleteById(Integer integer) {

    }


    @Override
    public void delete(LigneOperation LigneOperation) {
        this.getDAO().delete(LigneOperation);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        this.getDAO().deleteAllById(ids);
    }


    @Override
    public void deleteAll(Iterable<? extends LigneOperation> ligneOperations) {
        this.getDAO().deleteAll(ligneOperations);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LigneOperation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<LigneOperation> findAll(Pageable pageable) {
        return null;
    }

}


