package com.bank.api.utils.converter.user;

import com.bank.api.dto.user.UserShot;
import com.bank.api.entity.User;

import static com.bank.api.utils.PhoneNumberUtils.adjustPhoneNumber;

public final class Converter {

    private Converter() {
    }

    public static User toUser(UserShot userDto) {
        var user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(adjustPhoneNumber(userDto.getPhone()));
        return user;
    }
}
