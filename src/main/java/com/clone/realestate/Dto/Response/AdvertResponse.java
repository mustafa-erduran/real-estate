package com.clone.realestate.Dto.Response;

import com.clone.realestate.Model.AdvertStatus;
import com.clone.realestate.Model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
