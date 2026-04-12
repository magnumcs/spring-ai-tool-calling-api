package com.practice.spring_ai_tool_calling_api.repository;

import com.practice.spring_ai_tool_calling_api.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Share, Long> {}
