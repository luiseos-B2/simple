package br.com.example.simple.service


import br.com.example.simple.screen.MoreScreen
import org.springframework.stereotype.Service

@Service
class MoreService {
    fun getMoreScreen() = MoreScreen
}