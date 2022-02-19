package com.github.alllef.tradingplatformbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PhotoAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String photo;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "advertisement_id")
    private Advertisement advertisement;
}
