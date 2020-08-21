package br.com.example.simple.controller

import br.com.example.simple.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController (
        private val loginService: LoginService
){

    @GetMapping
    fun getLoginScreen() = this.loginService.getLoginScreen()

}