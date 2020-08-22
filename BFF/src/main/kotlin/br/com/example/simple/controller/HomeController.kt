package br.com.example.simple.controller

import br.com.example.simple.service.HomeService
import br.com.example.simple.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController (
        private val homeService: HomeService
){

    @GetMapping
    fun getHomeScreen() = this.homeService.getHomeScreen()

}