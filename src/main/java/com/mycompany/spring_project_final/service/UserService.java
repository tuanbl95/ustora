package com.mycompany.spring_project_final.service;

import com.mycompany.spring_project_final.common.PasswordUtil;
import com.mycompany.spring_project_final.entities.UserEntity;
import com.mycompany.spring_project_final.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserByEmailAndPassWord(String email, String password) {
        String hassPassword = PasswordUtil.hashPassword(password);
        return userRepository.findByEmailAndPassword(email, hassPassword);
    }

    public List<UserEntity> getLstUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
