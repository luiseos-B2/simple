package br.com.example.simple.service

import br.com.example.simple.screen.PublicacoesScreen
import org.springframework.stereotype.Service

@Service
class PublicacoesService {
    fun getPublicacoesScreen() = PublicacoesScreen
}