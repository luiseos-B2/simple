package br.com.example.simple.controller

import br.com.example.simple.service.RegisterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/register")
class RegisterController(
        private val registerService: RegisterService
) {

    @GetMapping
    fun getRegister() = this.registerService.getRegisterScreen()
}