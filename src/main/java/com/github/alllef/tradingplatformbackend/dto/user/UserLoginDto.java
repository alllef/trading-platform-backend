package com.github.alllef.tradingplatformbackend.dto.user;

import lombok.Data;

@Data
public class UserLoginDto {
    private String password;
    private String telegramNickName;
}
