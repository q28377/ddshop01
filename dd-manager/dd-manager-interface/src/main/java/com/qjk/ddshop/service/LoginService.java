package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.MessageResult;

public interface LoginService {
    MessageResult userLogin(String username, String password);
}
