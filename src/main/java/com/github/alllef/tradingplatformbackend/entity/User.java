package com.github.alllef.tradingplatformbackend.entity;

import com.github.alllef.tradingplatformbackend.entity.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "platform_user")
@Builder(toBuilder = true)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "advertisement", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Advertisement> adverts;
}
