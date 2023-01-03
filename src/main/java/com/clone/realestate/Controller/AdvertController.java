package com.clone.realestate.Controller;

import com.clone.realestate.Dto.Request.AdvertRequest;
import com.clone.realestate.Dto.Response.AdvertResponse;
import com.clone.realestate.Model.Advert;
import com.clone.realestate.Model.AdvertStatus;
import com.clone.realestate.Service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @PostMapping("/adverts")
    public ResponseEntity<AdvertResponse> addAdvert(@RequestBody AdvertRequest request){
        return new ResponseEntity<>(advertService.addAdvert(request), HttpStatus.CREATED);
    }

    @GetMapping("/adverts")
    public ResponseEntity<List<AdvertResponse>> getAllAdverts(@RequestParam(required = false) AdvertStatus status){
        List<AdvertResponse> adverts = status == null ?  advertService.getAllAdverts() : advertService.getActiveAdverts(status);
        return new ResponseEntity<>(adverts,HttpStatus.OK);
    }

    @GetMapping("/adverts/users/{id}")
    public ResponseEntity<List<AdvertResponse>> getAdvertByUserId(@PathVariable UUID id){
        return new ResponseEntity<>(advertService.getAdvertByOwnerId(id),HttpStatus.OK);
    }





}
