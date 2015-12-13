package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.Pic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring based {@code MongoRepository} implementation for {@code ActorRepository}.
 */
public interface PicRepository extends MongoRepository<Pic, String> {
    @Query("{userId : ?0}")
    public List<Pic> findByUserId(String userId);

}
