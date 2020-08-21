package br.com.example.simple.service


import br.com.example.simple.builder.OnboardingScreen
import org.springframework.stereotype.Service

@Service
class OnboardingService {
    fun getOnboardingScreen() = OnboardingScreen()
}