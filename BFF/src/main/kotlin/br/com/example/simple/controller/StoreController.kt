package br.com.example.simple.controller

import br.com.example.simple.service.OnboardingService
import br.com.example.simple.service.ProfileService
import br.com.example.simple.service.StoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/store")
class StoreController(
        private val storeService: StoreService
){
    @GetMapping
    fun getStoreScreen() = this.storeService.getStoreScreen()

}