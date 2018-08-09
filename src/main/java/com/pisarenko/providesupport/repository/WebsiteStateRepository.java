package com.pisarenko.providesupport.repository;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteStateRepository extends JpaRepository<WebsiteState, Website> {
    WebsiteState findWebsiteStateById(String id);
}
