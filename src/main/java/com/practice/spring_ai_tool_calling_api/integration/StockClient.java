package com.practice.spring_ai_tool_calling_api.integration;

import com.practice.spring_ai_tool_calling_api.integration.dto.StockData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wallet-api", url = "${spring.openfeign.twelve-data.url}")
public interface StockClient {

    @GetMapping
    StockData getStock(@PathVariable("symbol") String company,
                       @PathVariable("interval") String interval,
                       @PathVariable("outputsize") int size,
                       @PathVariable("apikey") String key);

}
