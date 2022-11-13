package com.bank.api.facade;

import com.bank.api.dto.user.UserShot;
import com.bank.api.entity.User;

import java.util.UUID;

public interface UserFacade extends BaseFacade<User, UserShot, UUID> {

    boolean existsByPhoneNumber(String phoneNumber);

}
