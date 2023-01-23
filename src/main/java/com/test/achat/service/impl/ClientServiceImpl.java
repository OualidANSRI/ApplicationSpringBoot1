package com.test.achat.service.impl;

import com.test.achat.entity.Client;
import com.test.achat.repository.DAO.Impl.IClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service("ClientService")
public class ClientServiceImpl implements IClientDAO {
    @Autowired
    IClientDAO clientDAO;


    public Client update(Client client) {
        return this.clientDAO.saveAndFlush(client);
    }

    public IClientDAO getDAO() {
        // TODO Auto-generated method stub
        return this.clientDAO;
    }
    public Optional <Client> findById(int id) {
        return clientDAO.findById(id);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Client> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(Integer id) {
        return this.getDAO().getOne(id);
    }

    @Override
    public Client getById(Integer id) {
        return this.getDAO().getById(id);
    }

    public Client create( Client client) {
        return this.getDAO().save(client);
    }

    @Override
    public Client getReferenceById(Integer id) {
        return this.getDAO().getReferenceById(id);
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> client) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> client) {
        return this.getDAO().findAll(client);
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> client) {
        return this.getDAO().exists(client);
    }

    @Override
    public <S extends Client, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Client> S save(S entity) {
        return this.getDAO().save(entity);
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return this.getDAO().findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return this.getDAO().existsById(id);
    }

    @Override
    public <S extends Client> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return this.getDAO().findAll();
    }

    @Override
    public List<Client> findAllById(Iterable<Integer> ids) {
        return this.getDAO().findAllById(ids);
    }

    @Override
    public long count() {
        return this.getDAO().count();
    }

    @Query("Alter table")
    @Override
    public void deleteById(Integer id) {
       this.getDAO().deleteById(id);
    }

    @Override
    public void delete(Client client) {
        this.getDAO().delete(client);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        this.getDAO().deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Client> clients) {
        this.getDAO().deleteAll(clients);
    }

    @Override
    public void deleteAll() {
        this.getDAO().deleteAll();
    }

    @Override
    public List<Client> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }
}