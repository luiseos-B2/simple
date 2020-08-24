package br.com.example.simple.service

import br.com.example.simple.screen.TipsScreen
import org.springframework.stereotype.Service

@Service
class TipsService {
    fun getTipsScreen() = TipsScreen
}