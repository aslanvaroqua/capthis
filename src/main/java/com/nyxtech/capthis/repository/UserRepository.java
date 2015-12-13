package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring based {@code MongoRepository} implementation for {@code ActorRepository}.
 */
public interface UserRepository extends MongoRepository<User, String> {
}
