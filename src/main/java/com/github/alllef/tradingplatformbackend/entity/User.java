package com.github.alllef.tradingplatformbackend.entity;

import com.github.alllef.tradingplatformbackend.dto.GetDtoConverter;
import com.github.alllef.tradingplatformbackend.dto.user.UserGetDto;
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
public class User implements GetDtoConverter<UserGetDto> {
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

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Advertisement> adverts;

    @OneToMany(mappedBy = "reviewAuthor",fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Review> givenReviews;

    @Override
    public UserGetDto toGetDto() {
        return UserGetDto.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .password(password)
                .telegramNickname(telegramNickname)
                .isVerified(isVerified)
                .role(role)
                .balance(balance)
                .registrationDate(registrationDate)
                .build();
    }
}
