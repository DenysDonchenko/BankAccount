package com.bank.api.service.impl;

import com.bank.api.entity.User;
import com.bank.api.repository.UserRepository;
import com.bank.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, UUID userId) {
        var userFromBd = userRepository.findById(userId).get();
        userFromBd.setLastName(user.getLastName());
        userFromBd.setPhone(user.getPhone());
        userFromBd.setFirstName(user.getFirstName());
        userFromBd.setEmail(user.getEmail());

        return userRepository.save(userFromBd);
    }

    @Override
    public boolean existsById(UUID userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhone(phoneNumber);
    }
}
