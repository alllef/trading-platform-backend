package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Currency;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<Currency,Long> {
}
