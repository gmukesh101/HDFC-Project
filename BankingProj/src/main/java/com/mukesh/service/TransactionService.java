package com.mukesh.service;

import com.mukesh.domain.entity.Transaction;
import java.util.List;

public interface TransactionService {

    List<Transaction> findTransactionsByCardId(long id);
}
