package com.github.alllef.tradingplatformbackend.service;

import com.github.alllef.tradingplatformbackend.repository.AdvertisementRepo;
import com.github.alllef.tradingplatformbackend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final AdvertisementRepo advertisementRepo;
    private final UserRepo userRepo;


}
