package br.com.example.simple.controller


import br.com.example.simple.service.NotificationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notification")
class NotificationController(
        private val notificationService: NotificationService
) {
    @GetMapping
    fun getNotificationScreen() = this.notificationService.getNotificationScreen()
}