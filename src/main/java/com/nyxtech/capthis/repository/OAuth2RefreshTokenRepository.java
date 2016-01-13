/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.OAuth2AuthenticationRefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author varoqua
 */

public interface OAuth2RefreshTokenRepository extends MongoRepository<OAuth2AuthenticationRefreshToken, String> {

   
}