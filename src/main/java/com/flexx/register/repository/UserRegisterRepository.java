package com.flexx.register.repository;

import com.flexx.register.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegisterRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByDocument(String document);
}
