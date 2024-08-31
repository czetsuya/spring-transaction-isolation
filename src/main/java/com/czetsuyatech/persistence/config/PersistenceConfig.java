package com.czetsuyatech.persistence.config;

import com.czetsuyatech.persistence.repositories.RepositoriesConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    basePackageClasses = {
        RepositoriesConfig.class
    })
@EnableTransactionManagement
public class PersistenceConfig {

}
