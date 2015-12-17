
package com.nyxtech.reviewcanvas.repository;

import com.nyxtech.reviewcanvas.entity.CheckIn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring based {@code MongoRepository} implementation for {@code CheckInRepository}.
 */
public interface CheckInRepository extends MongoRepository<CheckIn, String> {

    @Query("{userId : ?0}")
    public List<CheckIn> findByUserId(String userId);

}