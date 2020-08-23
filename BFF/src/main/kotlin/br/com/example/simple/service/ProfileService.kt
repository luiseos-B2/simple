package br.com.example.simple.service


import br.com.example.simple.screen.ProfileScreen
import org.springframework.stereotype.Service

@Service
class ProfileService {
    fun getProfileScreen() = ProfileScreen
}