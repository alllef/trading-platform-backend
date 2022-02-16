package com.github.alllef.tradingplatformbackend.dto.user;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String name;
    private String surname;
    private String password;
    private String telegramNickName;
}
