package com.maksym.dodoplan.service;


public interface TokenService {

    Long parseToken(String token);

    String createToken(Long id);
}
