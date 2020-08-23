package br.com.example.simple.controller

import br.com.example.simple.service.ProductsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsController(
        private val productsService: ProductsService
) {
    @GetMapping
    fun getProductsScreen() = this.productsService.getProductsScreen()
}