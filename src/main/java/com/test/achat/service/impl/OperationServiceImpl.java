package com.test.achat.service.impl;
import com.test.achat.entity.Operation;
import com.test.achat.repository.DAO.Impl.IOperationDAO;
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

    @Service("OperationService")
    public class OperationServiceImpl implements IOperationDAO {

        @Autowired
        IOperationDAO operationDAO;
        public Operation update(Operation operationUpdated) {

                return this.getDAO().saveAndFlush(operationUpdated);
        }
        public IOperationDAO getDAO() {
            // TODO Auto-generated method stub
            return this.operationDAO;
        }
        public Optional<Operation> findById(int id) {
            return operationDAO.findById(id);
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Operation> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Operation> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Operation> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Operation getOne(Integer integer) {
            return null;
        }

        public Operation create( Operation operation) {
            return this.getDAO().save(operation);
        }

        @Override
        public Operation getById(Integer id) {
            return this.getDAO().getById(id);
        }

        @Override
        public Operation getReferenceById(Integer integer) {
            return null;
        }

        @Override
        public <S extends Operation> Optional<S> findOne(Example<S> operation) {
            return Optional.empty();
        }

        @Override
        public <S extends Operation> List<S> findAll(Example<S> operation) {
            return this.getDAO().findAll(operation);
        }

        @Override
        public <S extends Operation> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Operation> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Operation> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Operation> boolean exists(Example<S> operation) {
            return this.getDAO().exists(operation);
        }

        @Override
        public <S extends Operation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public <S extends Operation> S save(S entity) {
            return this.getDAO().save(entity);
        }

        @Override
        public Optional<Operation> findById(Integer id) {
            return this.getDAO().findById(id);
        }

        @Override
        public boolean existsById(Integer id) {
            return this.getDAO().existsById(id);
        }

        @Override
        public <S extends Operation> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Operation> findAll() {
            return this.getDAO().findAll();
        }

        @Override
        public List<Operation> findAllById(Iterable<Integer> ids) {
            return this.getDAO().findAllById(ids);
        }

        @Override
        public long count() {
            return this.getDAO().count();
        }

        @Override
        public void deleteById(Integer id) {
            this.getDAO().deleteById(id);
        }

        @Override
        public void delete(Operation operation) {
            this.getDAO().delete(operation);
        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> ids) {
            this.getDAO().deleteAllById(ids);
        }

        @Override
        public void deleteAll(Iterable<? extends Operation> operations) {
            this.getDAO().deleteAll(operations);
        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Operation> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Operation> findAll(Pageable pageable) {
            return null;
        }
    }

