package com.youlearncode.springBootJPA.repository;

import com.youlearncode.springBootJPA.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {}
