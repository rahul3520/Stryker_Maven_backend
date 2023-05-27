package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.config.AppConfig;
import com.Stryker_Backend.Maven.service.TicketDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppConfigTests {

    @Test
    public void testTicketDetailsServiceBeanCreation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TicketDetailsService ticketDetailsService = context.getBean(TicketDetailsService.class);
        assertNotNull(ticketDetailsService);
    }

    // Other unit test cases for additional beans and configurations in AppConfig
}
