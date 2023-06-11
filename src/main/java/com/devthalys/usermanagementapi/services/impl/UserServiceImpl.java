package com.devthalys.usermanagementapi.services.impl;

import com.devthalys.usermanagementapi.models.UserModel;
import com.devthalys.usermanagementapi.repositories.UserRepository;
import com.devthalys.usermanagementapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(UUID id) {
        return userRepository.findById(id)
                .map(userId -> {
                    userId.getId();
                    return userId;
                }).orElseThrow(() -> new RuntimeException("User not found."));
    }

    @Override
    public void save(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public void delete(UserModel user) {
        userRepository.delete(user);
    }

    @Override
    public void update(UserModel user) {
        userRepository.save(user);
    }
}
