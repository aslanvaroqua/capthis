/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.OAuth2AuthenticationAccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 *
 * @author varoqua
 */
public interface OAuth2AccessTokenRepository extends MongoRepository<OAuth2AuthenticationAccessToken, Serializable> {

}
