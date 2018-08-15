package com.pisarenko.webmonitoringtool.repository;

import com.pisarenko.webmonitoringtool.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, String> {

    Website findWebsiteById(String id);

    @Query(value = "SELECT * FROM websites WHERE website_status='ACTIVE'", nativeQuery = true)
    List<Website> findActiveWebsites();

}
