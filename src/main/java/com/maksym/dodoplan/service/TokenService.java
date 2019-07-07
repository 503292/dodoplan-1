package com.maksym.dodoplan.service;

import org.springframework.stereotype.Service;


public interface TokenService {

    Long parseToken(String token);

    String createToken(Long id);
}
