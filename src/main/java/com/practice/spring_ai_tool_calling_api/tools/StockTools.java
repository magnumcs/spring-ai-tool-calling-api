package com.practice.spring_ai_tool_calling_api.tools;

import com.practice.spring_ai_tool_calling_api.integration.StockClient;
import com.practice.spring_ai_tool_calling_api.integration.dto.DailyStockData;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockData;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;

public class StockTools {

    private static final Logger logger = LoggerFactory.getLogger(StockTools.class);

    @Value("${spring.application.openfeign.twelve-data.key:none}")
    String apiKey;

    private final StockClient stockClient;

    public StockTools(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Tool(description = "Latest stock prices")
    public StockResponse getLatestStockPrices(@ToolParam(description = "Name of Company") String company){
        logger.info("Get stock prices for: {}", company);
        StockData data = stockClient.getStock(company, "1day", 1, apiKey);
        DailyStockData latestData = data.getValues().getFirst();
        logger.info("Get stock prices ({}) -> {}", company, latestData);
        return new StockResponse(Float.parseFloat(latestData.getClose()));
    }

}
