package com.pisarenko.webmonitoringtool.repository;

import com.pisarenko.webmonitoringtool.model.Website;
import com.pisarenko.webmonitoringtool.model.WebsiteState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteStateRepository extends JpaRepository<WebsiteState, Website> {
    WebsiteState findWebsiteStateById(String id);
}
