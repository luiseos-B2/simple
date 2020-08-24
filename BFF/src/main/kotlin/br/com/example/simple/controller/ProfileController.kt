package br.com.example.simple.controller

import br.com.example.simple.service.ProfileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profile")
class ProfileController(
        private val profileService: ProfileService
) {
    @GetMapping
    fun getProfileScreen() = this.profileService.getProfileScreen()

}