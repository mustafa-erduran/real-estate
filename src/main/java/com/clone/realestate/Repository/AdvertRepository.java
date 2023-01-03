package com.clone.realestate.Repository;

import com.clone.realestate.Model.Advert;

import com.clone.realestate.Model.AdvertStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@EnableJpaRepositories
public interface AdvertRepository extends JpaRepository<Advert,UUID>{
     List<Advert> getAdvertByOwnerId(UUID ownerId);
     List<Advert> getAdvertByStatus(AdvertStatus status);
}
