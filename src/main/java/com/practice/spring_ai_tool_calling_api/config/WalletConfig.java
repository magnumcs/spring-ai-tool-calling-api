package com.practice.spring_ai_tool_calling_api.config;

import com.practice.spring_ai_tool_calling_api.integration.StockClient;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockRequest;
import com.practice.spring_ai_tool_calling_api.integration.dto.StockResponse;
import com.practice.spring_ai_tool_calling_api.integration.dto.WalletResponse;
import com.practice.spring_ai_tool_calling_api.repository.WalletRepository;
import com.practice.spring_ai_tool_calling_api.service.StockService;
import com.practice.spring_ai_tool_calling_api.service.WalletService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class WalletConfig {

    private final StockClient stockClient;

    public WalletConfig(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Bean
    @Description("Number of shares for each company in my portfolio")
    public Supplier<WalletResponse> numberOfShares(WalletRepository repository) {
        return new WalletService(repository);
    }

    @Bean
    @Description("Latest Stock Prices")
    public Function<StockRequest, StockResponse> latestStockPrices(){
        return new StockService(stockClient);
    }

}