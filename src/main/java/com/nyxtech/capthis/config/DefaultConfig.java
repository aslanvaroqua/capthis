package com.nyxtech.capthis.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Default Configurations.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.nyxtech.capthis")
public class DefaultConfig {

}

