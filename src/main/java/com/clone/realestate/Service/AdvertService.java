package com.clone.realestate.Service;

import com.clone.realestate.Dto.Request.AdvertRequest;
import com.clone.realestate.Dto.Response.AdvertResponse;
import com.clone.realestate.Model.Advert;
import com.clone.realestate.Model.AdvertStatus;
import com.clone.realestate.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;


@Service
@Slf4j
public class AdvertService {

    private static Integer advertNo = 22345;
    private Map<Integer,Advert> advertMap  = new HashMap<>();
    @Autowired
    private UserService userService;

    private Advert convertRequestToAdvert(AdvertRequest request, Optional<User> foundUser) {
        Advert advert = null;
        if (foundUser.isPresent()) {
            advert = Advert.builder()
                    .creator(foundUser.get())
                    .advertNo(advertNo)
                    .status(request.getStatus())
                    .price(request.getPrice())
                    .createdDate(request.getCreatedDate())
                    .title(request.getTitle())
                    .build();
        } else {
            log.info("User not found!");
        }
        return advert;

    }

    private AdvertResponse convertAdvertToAdvertResponse(Advert savedAdvert){
        return AdvertResponse.builder()
                .user(savedAdvert.getCreator())
                .title(savedAdvert.getTitle())
                .price(savedAdvert.getPrice())
                .createdDate(savedAdvert.getCreatedDate())
                .status(savedAdvert.getStatus())
                .imageList(savedAdvert.getImageList())
                .build();
    }

    public AdvertResponse createAdvert(AdvertRequest request){
        Optional<User> foundUser = userService.findUserByUserId(request.getUserId());
        Advert savedAdvert = convertRequestToAdvert(request);

    }
}
