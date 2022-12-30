package com.clone.realestate.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advert {

    private Integer advertNo;
    private String title;
    private BigDecimal price;
    private Date createdDate;
    private AdvertStatus status;
    private List<String> imageList;

    private User creator;

    public UUID generateId(){ return UUID.randomUUID(); }



}
