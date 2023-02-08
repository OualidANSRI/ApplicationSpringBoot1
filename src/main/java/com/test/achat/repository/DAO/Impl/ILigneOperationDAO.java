package com.test.achat.repository.DAO.Impl;

import com.test.achat.entity.LigneOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ligneOperation")
public interface ILigneOperationDAO extends JpaRepository<LigneOperation, Integer> {

}