package com.devthalys.usermanagementapi.services;

import com.devthalys.usermanagementapi.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    List<UserModel> findAll();
    UserModel findById(UUID id);
    void save(UserModel user);
    void delete(UserModel user);
    void update(UserModel user);
}
