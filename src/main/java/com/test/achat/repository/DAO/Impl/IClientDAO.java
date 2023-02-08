package com.test.achat.repository.DAO.Impl;


import com.test.achat.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("client")
public interface IClientDAO extends JpaRepository<Client, Integer> {

}
