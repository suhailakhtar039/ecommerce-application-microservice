package com.ecommerce.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

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

    @Bean
    public Supplier<Message<String>> sendRiderStatus(){
        Random random = new Random();
        return () -> {
            String riderId = "riderId " + random.nextInt(100);
            String status = random.nextBoolean() ? "Ride started" : "Ride ended";
            System.out.println("Sending : " + status);
            return MessageBuilder.withPayload(riderId + " : " + status)
                    .setHeader(KafkaHeaders.KEY, riderId.getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }
}
