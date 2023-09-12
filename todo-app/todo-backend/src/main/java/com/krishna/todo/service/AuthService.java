package com.krishna.todo.service;

import com.krishna.todo.dto.LoginDto;
import com.krishna.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
