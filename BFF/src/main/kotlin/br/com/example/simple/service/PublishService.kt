package br.com.example.simple.service

import br.com.example.simple.screen.PublishScreen
import org.springframework.stereotype.Service

@Service
class PublishService {
    fun getPublishScreen() = PublishScreen
}