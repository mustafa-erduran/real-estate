package com.clone.realestate.dto.response;

import com.clone.realestate.model.AdvertStatus;
import com.clone.realestate.model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class AdvertResponse {

    private User user;
    private String title;
    private BigDecimal price;
    private Date createdDate;
    private AdvertStatus status;
    private List<String> imageList;
}
