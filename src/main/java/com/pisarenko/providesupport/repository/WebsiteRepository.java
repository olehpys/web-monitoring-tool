package com.pisarenko.providesupport.repository;

import com.pisarenko.providesupport.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, String> {

    Website findWebsiteById(String id);

    @Override
    List<Website> findAll();
}
