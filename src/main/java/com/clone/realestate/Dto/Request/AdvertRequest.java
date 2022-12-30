package com.clone.realestate.Dto.Request;

import com.clone.realestate.Model.AdvertStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class AdvertRequest {

    private UUID userId;
    private String title;
    private BigDecimal price;
    private Date createdDate;
    private AdvertStatus status;
    private List<String> imageList;

}
