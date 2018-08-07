package com.pisarenko.providesupport.repository;

import com.pisarenko.providesupport.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, String> {

    Website findWebsiteById(String id);

}
