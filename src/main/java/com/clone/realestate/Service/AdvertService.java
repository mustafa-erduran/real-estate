package com.clone.realestate.Service;

import com.clone.realestate.Dto.Request.AdvertRequest;
import com.clone.realestate.Dto.Response.AdvertResponse;
import com.clone.realestate.Model.Advert;
import com.clone.realestate.Model.AdvertStatus;
import com.clone.realestate.Model.User;
import com.clone.realestate.Repository.AdvertRepository;
import com.clone.realestate.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;


@Service
@Slf4j
public class AdvertService {

    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private UserRepository userRepository;

    private Advert convertRequestToAdvert(AdvertRequest request, Optional<User> foundUser) {
        Advert advert = null;
        if (foundUser.isPresent()) {
            advert = Advert.builder()
                    .owner(foundUser.get())
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
                .user(savedAdvert.getOwner())
                .title(savedAdvert.getTitle())
                .price(savedAdvert.getPrice())
                .createdDate(savedAdvert.getCreatedDate())
                .status(savedAdvert.getStatus())
                .imageList(savedAdvert.getImageList())
                .build();
    }

    public AdvertResponse addAdvert(AdvertRequest request){
        Optional<User> foundUser = userRepository.findById(request.getUserId());
        Advert advert = convertRequestToAdvert(request,foundUser);

        advertRepository.save(advert);
        return convertAdvertToAdvertResponse(advert);
    }

    public List<AdvertResponse> getAllAdverts(){
        List<AdvertResponse> advertList = new ArrayList<>();
        for(Advert advert : advertRepository.findAll()){
            advertList.add(convertAdvertToAdvertResponse(advert));
        }
        return advertList;
    }

    public List<AdvertResponse> getAdvertByOwnerId(UUID userId){
        List<AdvertResponse> advertList = new ArrayList<>();
        for(Advert advert : advertRepository.getAdvertByOwnerId(userId)){
            advertList.add(convertAdvertToAdvertResponse(advert));
        }
        return advertList;
    }

    public List<AdvertResponse> getActiveAdverts(AdvertStatus status){
        List<AdvertResponse> advertList = new ArrayList<>();
        for(Advert advert : advertRepository.getAdvertByStatus(status)){
            advertList.add(convertAdvertToAdvertResponse(advert));
        }
        return advertList;
    }

}
