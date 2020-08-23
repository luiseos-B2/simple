package br.com.example.simple.controller

import br.com.example.simple.service.PublicacoesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/publicacoes")
class PublicacoesController(
        private val publicacoesService: PublicacoesService
) {
    @GetMapping
    fun getPublicacoesScreen() = this.publicacoesService.getPublicacoesScreen()
}