package com.practice.spring_ai_tool_calling_api.service;

import com.practice.spring_ai_tool_calling_api.integration.StockClient;
import com.practice.spring_ai_tool_calling_api.integration.dto.DailyStockData;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockData;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockRequest;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StockService implements Function<StockRequest, StockResponse> {

    private final StockClient stockClient;

    @Value("${spring.application.openfeign.twelve-data.key:none}")
    String apiKey;

    public StockService(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public StockResponse apply(StockRequest stockRequest) {
        StockData data = stockClient.getStock(
                stockRequest.company(),
                "1day",
                1,
                apiKey);
        DailyStockData latestData = data.getValues().getFirst();
        return new StockResponse(Float.parseFloat(latestData.getClose()));
    }
}
