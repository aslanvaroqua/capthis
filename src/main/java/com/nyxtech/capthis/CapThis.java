package com.nyxtech.capthis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by varoqua on 12/10/15.
 */

@ComponentScan
@EnableAutoConfiguration
public class CapThis {
    public static void main(String[] args) {
        SpringApplication.run(CapThis.class, args);
    }
}
