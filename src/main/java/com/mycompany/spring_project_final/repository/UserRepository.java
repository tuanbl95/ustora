package com.mycompany.spring_project_final.repository;

import com.mycompany.spring_project_final.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmailAndPassword(String email, String password);

}
