package com.api.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, String> {

}
