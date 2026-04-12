package com.practice.spring_ai_tool_calling_api.service;

import com.practice.spring_ai_tool_calling_api.integration.dto.WalletResponse;
import com.practice.spring_ai_tool_calling_api.repository.WalletRepository;

import java.util.function.Supplier;

public class WalletService implements Supplier<WalletResponse> {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public WalletResponse get() {
        var shares = repository.findAll();
        return new WalletResponse(shares);
    }
}
