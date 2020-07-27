package com.mukesh.service;

import com.mukesh.domain.entity.Card;
import com.mukesh.domain.entity.Transaction;
import com.mukesh.domain.entity.User;
import com.mukesh.forms.UserCreateForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<Card> findUserCardsById(long id);
    List<Transaction> findTransactionsByCardId(long id);
    User registerUser(UserCreateForm userCreateForm);
    boolean hasValidPassword(User user, String pwd);
}
