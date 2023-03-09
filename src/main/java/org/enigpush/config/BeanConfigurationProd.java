package org.enigpush.config;

import org.enigpush.repository.BookRepo;
import org.enigpush.repository.IBookRepo;
import org.enigpush.service.BookService;
import org.enigpush.service.IBookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("prod")
@Configuration
@PropertySource("classpath:app-${spring.profiles.active}.properties")
public class BeanConfigurationProd {
    @Value("${client.header}")
    private String clientHeader;
    @Value("${driver}")
    private String dbDriver;
    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbUser;
    @Value("${dbpassword}")
    private String dbPassword;
    @Bean
    public IBookService getBookService(){
        return new BookService(getBookRepo());
    }
    @Bean
    public IBookRepo getBookRepo(){
        return new BookRepo(dataSource());
    }
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);
        return driverManagerDataSource;
    }
}
