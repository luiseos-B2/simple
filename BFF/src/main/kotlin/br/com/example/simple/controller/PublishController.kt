package br.com.example.simple.controller

import br.com.example.simple.service.PublishService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/myposts")
class PublishController(
        private val publishService: PublishService
) {
    @GetMapping
    fun getPublishScreen() = this.publishService.getPublishScreen()
}