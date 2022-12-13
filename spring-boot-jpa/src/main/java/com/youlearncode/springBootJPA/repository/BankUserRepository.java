package com.youlearncode.springBootJPA.repository;

import com.youlearncode.springBootJPA.model.BankUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BankUserRepository extends CrudRepository<BankUser, Long> {

    @Query("SELECT bu FROM BankUser bu")
    @EntityGraph(value = "BankUser.cards")
    List<BankUser> findAllWithCards();
}
