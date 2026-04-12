package com.practice.spring_ai_tool_calling_api.tools;

import com.practice.spring_ai_tool_calling_api.entities.Share;
import com.practice.spring_ai_tool_calling_api.repository.WalletRepository;
import org.springframework.ai.tool.annotation.Tool;

import java.util.List;

public class WalletTools {

    private final WalletRepository repository;

    public WalletTools(WalletRepository repository) {
        this.repository = repository;
    }

    @Tool(description = "Number of shares for each company in my wallet")
    public List<Share> getNumberOfShares(){
        return repository.findAll();
    }
}
