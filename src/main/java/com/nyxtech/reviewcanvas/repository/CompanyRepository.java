
package com.nyxtech.reviewcanvas.repository;

import com.nyxtech.reviewcanvas.entity.CheckIn;
import com.nyxtech.reviewcanvas.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring based {@code MongoRepository} implementation for {@code CompanyRepository}.
 */
public interface CompanyRepository extends MongoRepository<Company, String> {


}