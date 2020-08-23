package br.com.example.simple.service

import br.com.example.simple.screen.DicasScreen
import org.springframework.stereotype.Service

@Service
class DicasService {
    fun getDicasScreen() = DicasScreen
}