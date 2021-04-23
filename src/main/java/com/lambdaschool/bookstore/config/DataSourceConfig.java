package com.lambdaschool.bookstore.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig
{
    private String dbValue;
    private String dbUrl;

    @Bean
    public DataSource dataSource()
    {
        if (dbValue.equalsIgnoreCase("POSTGRESQL"))
        {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }else
        {
            String myURLString = "jbdc:h2:mem:testdb";
            String myDriverClass = "org.h2.Driver";
            String myDBUser = "sa";
            String myDBPassword = "";

            return DataSourceBuilder.create()
                    .username(myDBUser)
                    .password(myDBPassword)
                    .url(myURLString)
                    .driverClassName(myDriverClass)
                    .build();
        }
    }
}