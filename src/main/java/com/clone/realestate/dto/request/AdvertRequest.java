package com.clone.realestate.dto.request;

import com.clone.realestate.model.AdvertStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AdvertRequest {

    private long userId;
    private String title;
    private BigDecimal price;
    private Date createdDate;
    private AdvertStatus status;
    private List<String> imageList;

}
