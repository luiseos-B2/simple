package br.com.example.simple.service

import br.com.example.simple.screen.NotificationScreen
import org.springframework.stereotype.Service

@Service
class NotificationService {
    fun getNotificationScreen() = NotificationScreen
}