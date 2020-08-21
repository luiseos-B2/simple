package br.com.example.simple.controller

import br.com.example.simple.service.OnboardingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/onboarding")
class OnboardingController(
        private val onboardingService: OnboardingService
){
    @GetMapping
    fun getOnboardingScreen() = this.onboardingService.getOnboardingScreen()

}