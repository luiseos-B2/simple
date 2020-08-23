package br.com.example.simple.service

import br.com.example.simple.screen.ProductsScreen
import org.springframework.stereotype.Service

@Service
class ProductsService {
    fun getProductsScreen() = ProductsScreen
}