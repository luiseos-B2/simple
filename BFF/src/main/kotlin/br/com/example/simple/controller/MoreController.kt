package br.com.example.simple.controller

import br.com.example.simple.service.MoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MoreController(
        private val moreService: MoreService
) {
    @GetMapping
    fun getMoreScreen() = this.moreService.getMoreScreen()
}