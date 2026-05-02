package com.ecommerce.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {
    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        return () -> {
            RiderLocation location = new RiderLocation("ryder1", 11.0, 12.3);
            System.out.println("Sending From sendRiderLocation method: " + location.getRiderId());
            return location;
        };
    }
}
