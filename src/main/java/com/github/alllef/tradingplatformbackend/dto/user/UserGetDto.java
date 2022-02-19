package com.github.alllef.tradingplatformbackend.dto.user;

import com.github.alllef.tradingplatformbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserGetDto {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String telegramNickname;
    private Boolean isVerified;
    private Role role;
    private BigDecimal balance;
    private LocalDate registrationDate;
    private BigDecimal averageMark;
}