package com.youlearncode.springBootJPA.repository;

import com.youlearncode.springBootJPA.model.BankUser;
import org.springframework.data.repository.CrudRepository;

public interface BankUserRepository extends CrudRepository<BankUser, Long> {}
