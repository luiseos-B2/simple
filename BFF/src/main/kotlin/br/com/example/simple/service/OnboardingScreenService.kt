package br.com.example.simple.service

import br.com.example.simple.builder.OnboardingScreenBuilder
import org.springframework.stereotype.Service

@Service
class OnboardingScreenService {
    fun createdOnboardingScreen() = OnboardingScreenBuilder().build()
}