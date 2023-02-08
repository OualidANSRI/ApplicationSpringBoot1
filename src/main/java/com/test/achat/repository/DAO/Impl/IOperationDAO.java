package com.test.achat.repository.DAO.Impl;
import com.test.achat.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("operation")
public interface IOperationDAO extends JpaRepository<Operation, Integer> {

}
