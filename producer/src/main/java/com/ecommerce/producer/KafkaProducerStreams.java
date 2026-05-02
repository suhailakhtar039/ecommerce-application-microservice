package com.ecommerce.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {
    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        Random random = new Random();
        String riderId = "riderId " + random.nextInt(100);
        return () -> {
            RiderLocation location = new RiderLocation(riderId, 11.0, 12.3);
            System.out.println("Sending From sendRiderLocation method: " + riderId);
            return location;
        };
    }
}
