package com.mukesh.service.impl;

import com.mukesh.domain.entity.Transaction;
import com.mukesh.repository.TransactionRepository;
import com.mukesh.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findTransactionsByCardId(long id) {
        return transactionRepository.findTransactionsByCardId(id);
    }
}
