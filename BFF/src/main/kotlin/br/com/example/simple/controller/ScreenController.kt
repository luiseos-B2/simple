package br.com.example.simple.controller

import br.com.example.simple.service.OnboardingScreenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScreenController(
        private val onboardingScreenService: OnboardingScreenService
){
    @GetMapping("/onboarding")
    fun getOmboardingScreen() = onboardingScreenService.createdOnboardingScreen()
}