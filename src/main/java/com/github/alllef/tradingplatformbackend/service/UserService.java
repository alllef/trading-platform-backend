package com.github.alllef.tradingplatformbackend.service;

import com.github.alllef.tradingplatformbackend.dto.user.UserGetDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserLoginDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserRegisterDto;
import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Review;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.entity.enums.UserRole;
import com.github.alllef.tradingplatformbackend.repository.AdvertisementRepo;
import com.github.alllef.tradingplatformbackend.repository.RoleRepo;
import com.github.alllef.tradingplatformbackend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AdvertisementRepo advertisementRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public Optional<User> registerUser(UserRegisterDto userRegisterDto) {
        String telegramNickName = userRegisterDto.getTelegramNickName();

        Optional<User> optUser = Optional.ofNullable(userRepo.findByTelegramNickname(telegramNickName));
        if (optUser.isEmpty()) {
            User newlyCreatedClient = User.builder()
                    .name(userRegisterDto.getName())
                    .surname(userRegisterDto.getSurname())
                    .password(userRegisterDto.getPassword())
                    .registrationDate(LocalDate.now())
                    .role(roleRepo.findByRole(UserRole.CLIENT))
                    .build();

            return Optional.of(userRepo.save(newlyCreatedClient));
        }

        return Optional.empty();
    }

    public Optional<User> loginUser(UserLoginDto userLoginDto) {
        String telegramNickName = userLoginDto.getTelegramNickName();
        Optional<User> optUser = Optional.ofNullable(userRepo.findByTelegramNickname(telegramNickName));
        if (optUser.isPresent()) {
            User user = optUser.get();
            if (user.getPassword()
                    .equals(userLoginDto.getPassword()))
                return optUser;
            else throw new RuntimeException();
        }
        return optUser;
    }

    public List<Review> getReviews(Long id){
        User user = userRepo.findById(id)
                .orElseThrow();

        return user.getGivenReviews()
                .stream()
                .toList();
    }

    public List<Advertisement> getAdvertisements(Long id){
        User user = userRepo.findById(id)
                .orElseThrow();

        return user.getAdverts()
                .stream()
                .toList();
    }

    public UserGetDto getUserById(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow();

        UserGetDto userGetDto = user.toGetDto();

        return userGetDto.toBuilder()
                .averageMark(calcAverageComments(user))
                .build();
    }


    public BigDecimal calcAverageComments(User user) {
        int reviewsNum = 0;
        BigDecimal advertsSum = new BigDecimal("0.0");

        for (Advertisement advert : user.getAdverts()) {
            BigDecimal reviewsSum = new BigDecimal("0.0");
            for (Review review : advert.getReviews()) {
                reviewsSum = reviewsSum.add(review.getMark());
                reviewsNum++;
            }

            advertsSum = advertsSum.add(reviewsSum);
        }
        return advertsSum.divide(BigDecimal.valueOf(reviewsNum), RoundingMode.HALF_UP);
    }

}
