package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.Caption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring based {@code MongoRepository} implementation for {@code ActorRepository}.
 */
public interface CaptionRepository extends MongoRepository<Caption, String> {

    @Query("{picId : ?0}")
    public List<Caption> findByPicId(String picId);

    @Query("{userId : ?0}")
    public List<Caption> findByUserId(String userId);

}
