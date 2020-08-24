package br.com.example.simple.controller

import br.com.example.simple.service.TipsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tips")
class TipsController(
        private val tipsService: TipsService
) {
    @GetMapping
    fun getTipsScreen() = this.tipsService.getTipsScreen()
}