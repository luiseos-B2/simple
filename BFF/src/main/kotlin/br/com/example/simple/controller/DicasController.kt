package br.com.example.simple.controller

import br.com.example.simple.service.DicasService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dicas")
class DicasController(
        private val dicasService: DicasService
) {
    @GetMapping
    fun getDicasScreen() = this.dicasService.getDicasScreen()
}