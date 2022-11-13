package com.bank.api.service;

import com.bank.api.entity.User;

import java.util.UUID;

public interface UserService extends BaseService<User, UUID> {

    boolean existsByPhoneNumber(String phoneNumber);
}
