package com.clone.realestate.Repository;

import com.clone.realestate.Model.Advert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface AdvertRepository extends JpaRepository<Advert,UUID>{
     List<Advert> getAdvertByUserId(UUID userId);
}
