package com.api.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String> {

}
