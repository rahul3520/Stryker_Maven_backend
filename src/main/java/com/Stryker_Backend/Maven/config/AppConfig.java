package com.Stryker_Backend.Maven.config;

import com.Stryker_Backend.Maven.service.TicketDetailsService;
import com.Stryker_Backend.Maven.service.TicketDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class AppConfig {

    @Bean
    public TicketDetailsService ticketDetailsService() {
        return new TicketDetailsServiceImpl();
    }

    // Other bean definitions and configuration
}
