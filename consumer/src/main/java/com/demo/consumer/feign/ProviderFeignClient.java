package com.demo.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider-service", url = "http://localhost:8081")
public interface ProviderFeignClient {
    String getInstance();
}
