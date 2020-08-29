package com.mukesh.service;

import java.util.List;

import com.mukesh.domain.entity.Card;

/**
 * @author mukesh
 *
 */
public interface CardService {

    List<Card> findCardsByUserId(long id);
    Card findCardById(long id);
}
