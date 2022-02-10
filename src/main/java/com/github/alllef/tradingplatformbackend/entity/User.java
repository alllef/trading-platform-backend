package com.github.alllef.tradingplatformbackend.entity;

import com.github.alllef.tradingplatformbackend.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String telegramNickname;

    @Column(columnDefinition = "boolean default false")
    private Boolean isVerified;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDate registrationDate;
}
