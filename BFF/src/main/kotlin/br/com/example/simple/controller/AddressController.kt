package br.com.example.simple.controller

import br.com.example.simple.service.AddressService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/address")
class AddressController(
        private val addressService: AddressService
) {
    @GetMapping
    fun getAddressScreen() = this.addressService.getAddressScreen()
}