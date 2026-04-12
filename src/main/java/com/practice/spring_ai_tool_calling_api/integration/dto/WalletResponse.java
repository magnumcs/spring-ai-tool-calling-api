package com.practice.spring_ai_tool_calling_api.integration.dto;

import com.practice.spring_ai_tool_calling_api.entities.Share;

import java.util.List;

public record WalletResponse(List<Share> shares) {}
