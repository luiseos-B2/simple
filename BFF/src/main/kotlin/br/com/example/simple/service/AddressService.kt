package br.com.example.simple.service

import br.com.example.simple.screen.AddressScreen
import org.springframework.stereotype.Service

@Service
class AddressService {
    fun getAddressScreen() = AddressScreen
}