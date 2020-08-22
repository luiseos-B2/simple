package br.com.example.simple.service

import br.com.example.simple.screen.RegisterScreen
import org.springframework.stereotype.Service

@Service
class RegisterService {
    fun getRegisterScreen() = RegisterScreen()
}