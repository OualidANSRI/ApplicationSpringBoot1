package com.test.achat.service.impl;

import com.test.achat.entity.Client;
import com.test.achat.repository.DAO.Impl.IClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import java.util.List;
import java.util.Optional;


//@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Service("clientService")
public class ClientServiceImpl {
    @Autowired
    private IClientDAO clientDAO;


    public IClientDAO getDAO() { return this.clientDAO; }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Client create( Client client) {
        return this.getDAO().save(client);
    }

    @CachePut(value ="client", key = "#client.getId()")
    public Client update(Client client) {
        return this.getDAO().saveAndFlush(client);
    }

    @Cacheable(value ="client", key = "#id")
    public Optional <Client> findById(int id) {
        return this.getDAO().findById(id);
    }

    @Cacheable(value ="listeClients")
    public List<Client> findAll() {
        return this.getDAO().findAll();
    }

    @CacheEvict(value = "client", key = "#id")
    public void deleteById(Integer id) {
        this.getDAO().deleteById(id);
    }

    @Caching(evict = { @CacheEvict(value = "client", allEntries = true), @CacheEvict(value = "listeClients", allEntries = true)})
    public void deleteAll() {
        this.getDAO().deleteAll();
    }

    public long count() {
        return this.getDAO().count();
    }

}