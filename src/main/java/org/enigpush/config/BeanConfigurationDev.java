package org.enigpush.config;

import org.enigpush.repository.BookRepo;
import org.enigpush.repository.BookRepoDev;
import org.enigpush.repository.IBookRepo;
import org.enigpush.service.BookService;
import org.enigpush.service.IBookService;
import org.springframework.context.annotation.*;

//@Profile("dev")
@Configuration
@PropertySource("classpath:app-${spring.profiles.active}.properties")
public class BeanConfigurationDev {

    @Bean
    public IBookService getBookService() {
        return new BookService(getBookArrayRepository());
    }

    @Bean
    public IBookRepo getBookArrayRepository() {
        return new BookRepoDev();
    }}

