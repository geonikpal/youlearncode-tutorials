package com.youlearncode.springBootJPA.repository;

import com.youlearncode.springBootJPA.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {}
