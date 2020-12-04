package com.offcn.shopping.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by 金喆
 */

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

}
