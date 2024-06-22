package com.example.SpringRestMySQL.service;

import com.example.SpringRestMySQL.dto.LoginDto;
import com.example.SpringRestMySQL.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
