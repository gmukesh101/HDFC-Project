package com.mukesh.service.impl;

import com.mukesh.domain.entity.Card;
import com.mukesh.domain.entity.Role;
import com.mukesh.domain.entity.Transaction;
import com.mukesh.domain.entity.User;
import com.mukesh.forms.UserCreateForm;
import com.mukesh.repository.UserRepository;
import com.mukesh.service.CardService;
import com.mukesh.service.RoleService;
import com.mukesh.service.TransactionService;
import com.mukesh.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mukesh.constants.GeneralConstants.ROLE_USER;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CardService cardService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<Card> findUserCardsById(long id) {
        return cardService.findCardsByUserId(id);
    }

    @Override
    public List<Transaction> findTransactionsByCardId(long id) {
        return transactionService.findTransactionsByCardId(id);
    }

    public User registerUser(UserCreateForm userCreateForm) {
        User user = new User();

        user.setUsername(userCreateForm.getUsername());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateForm.getPassword()));

        Set<Role> roles = generateRolesSet();
        user.setRoles(roles);
        user.setCards(new ArrayList<>());

        return userRepository.save(user);
    }

    private Set<Role> generateRolesSet() {
        Role role = roleService.findByRoleName(ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    public boolean hasValidPassword(User user, String pwd) {
        return passwordEncoder.matches(pwd, user.getPassword());
    }
}
