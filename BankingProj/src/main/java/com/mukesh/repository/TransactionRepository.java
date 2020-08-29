package com.mukesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mukesh.domain.entity.Transaction;

import java.util.List;

/**
 * @author mukesh
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findTransactionsByCardId(long id);
}
