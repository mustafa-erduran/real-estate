package com.clone.realestate.Model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "advert")
public class Advert {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false)
    private UUID id = UUID.randomUUID();
    //@Column(unique = false)
    //private Integer advertNo;
    private String title;
    private BigDecimal price;
    private Date createdDate;
    @Enumerated(value = EnumType.STRING)
    private AdvertStatus status;
    private List<String> imageList;
    @OneToOne
    @JoinColumn(name = "user-id", referencedColumnName = "id")
    private User creator;



}
