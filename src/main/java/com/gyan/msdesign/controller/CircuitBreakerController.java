package com.gyan.msdesign.controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

   Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

   @GetMapping("/sample-api")
   @Retry(name = "sample-api",fallbackMethod = "responseAfterRetry")
   public String sampleApi(){
     logger.info("sample api request received");
    return  new RestTemplate().getForEntity("http://localhost:8080/dummy",
                                            String.class).getBody();

     // return "some sample api";
   }

   @GetMapping("/circuit-breaker-sample-api")
   @CircuitBreaker(name = "circuit-breaker-profile",fallbackMethod = "responseAfterRetry")
   public String circuitBreakerSampleApi(){
      logger.info("sample api request received for circuit breaker");
      return  new RestTemplate().getForEntity("http://localhost:8080/dummy",
              String.class).getBody();

      // return "some sample api";
   }


   @GetMapping("/rate-limiter-sample-api")
   @RateLimiter(name = "default")
   public String rateLimiterSampleApi(){
      return "rate limiter sample api";
   }

   @GetMapping("/bulk-head-sample-api")
   @Bulkhead(name = "default")
   public String bulkHeadSampleApi(){
      return "bulk head sample api";
   }

   public String responseAfterRetry(Exception ex){
      return "response from default method";
   }
}
