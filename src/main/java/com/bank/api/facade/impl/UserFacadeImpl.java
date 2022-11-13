package com.bank.api.facade.impl;

import com.bank.api.dto.user.UserShot;
import com.bank.api.entity.User;
import com.bank.api.facade.UserFacade;
import com.bank.api.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.bank.api.utils.PhoneNumberUtils.adjustPhoneNumber;
import static com.bank.api.utils.converter.user.Converter.toUser;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userService.findAll();
    }

    @Override
    public User findById(UUID userId) {
        return userService.findById(userId).get();
    }

    @Override
    public User create(UserShot userDto) {
        return userService.create(toUser(userDto));
    }

    @Override
    public User update(UserShot userDto, UUID userId) {
        return userService.update(toUser(userDto), userId);
    }

    @Override
    public boolean existsById(UUID userId) {
        return userService.existsById(userId);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return userService.existsByPhoneNumber(adjustPhoneNumber(phoneNumber));
    }
}
