package com.api.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
