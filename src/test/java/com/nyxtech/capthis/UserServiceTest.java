/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.nyxtech.capthis;

import com.nyxtech.capthis.entity.ClientDetail;
import com.nyxtech.capthis.entity.User;
import com.nyxtech.capthis.service.UserService;
import com.nyxtech.capthis.service.security.ClientDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.Assert.assertNotEquals;

/**
*
* @author varoqua
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CapThis.class)
@WebAppConfiguration
@IntegrationTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientDetailService clientDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    User awesomeUser;
    ClientDetail authClient;
    @Value("${app.client.id}")
    private String authClientId;
    @Value("${app.client.secret}")
    private String authClientSecret;

    static PodamFactory podamFactory;

    @Before
    public void setUp() {

        podamFactory = new PodamFactoryImpl();
        userService.deleteAll();
        clientDetailService.deleteAll();

//       awesomeUser = podamFactory.manufacturePojo(User.class);
        awesomeUser = new User();

        awesomeUser.setEmail("user@awesome.com");
        awesomeUser.setPassword(passwordEncoder.encode("cant_hack_this"));
        awesomeUser.setId("thisis-awesome-1");
        awesomeUser.setDisplayName("user@awesome.com");
        awesomeUser.setFirstName("Aslan");
        awesomeUser.setLastName("Varoqua");
        userService.save(awesomeUser);

        authClient = new ClientDetail();
        authClient.setId(UUID.randomUUID().toString());
        authClient.setClientId(authClientId);
        authClient.setResourceIds(new HashSet<>(Arrays.asList("rest_api")));
        authClient.setClientSecret(passwordEncoder.encode(authClientSecret));
        authClient.setRefreshTokenValiditySeconds(86400);
        authClient.setAccessTokenValiditySeconds(86400);
        authClient.setAuthorities(new HashSet<>(Arrays.asList("trust", "read", "write")));
        authClient.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList("client_credentials", "authorization_code", "implicit", "password", "refresh_token")));
        authClient.setScope(new HashSet<>(Arrays.asList("trust", "read", "write")));
        authClient.setSecretRequired(true);

        clientDetailService.save(authClient);

    }

    @Test
    public void checkingAWESOME() {
        assertNotEquals("awesome", "AWESOME");
    }

    ///other chats here

}
