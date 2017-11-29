package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.MessageResult;

public interface TokenService {
    MessageResult getUserByToken(String tokenId);
}
