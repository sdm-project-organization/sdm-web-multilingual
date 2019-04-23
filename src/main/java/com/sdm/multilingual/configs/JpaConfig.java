package com.sdm.multilingual.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="securityAuditorAware")
@Configuration
public class JpaConfig {

}
