package com.demo.consumer.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign")
public class FeignController {
    public String getInstance(){
        return "";
    }
}
