package com.example.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.login.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<UserModel> findByUsernameAndPassword(String username, String password);
    Optional<UserModel> findByUsername(String username);
}

