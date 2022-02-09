package com.github.alllef.tradingplatformbackend.entity;

import com.github.alllef.tradingplatformbackend.entity.enums.AdvertType;
import lombok.*;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdvertType type;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDate creationDate;

    private LocalDate closeDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_closed_id")
    private User closedByModerator;

    @Column(nullable = false)
    private String advertName;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "advertisement")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PhotoAdvert> photos;

    @OneToOne(mappedBy = "advertisement")
    private Review review;
}