package com.github.alllef.tradingplatformbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class PhotoAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String photo;
    @ManyToOne
    @Column(nullable = false)
    private Advertisement advertisementId;
}
