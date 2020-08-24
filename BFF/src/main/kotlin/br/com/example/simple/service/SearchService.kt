package br.com.example.simple.service

import br.com.example.simple.screen.SearchOpportunityScreen
import br.com.example.simple.screen.SearchProductsScreen
import br.com.example.simple.screen.SearchServicesScreen
import br.com.example.simple.screen.SearchStoreScreen
import org.springframework.stereotype.Service

@Service
class SearchService {

    fun getSearchServicesScreen() = SearchServicesScreen()

    fun getSearchStoreScreen() = SearchStoreScreen()

    fun getSearchOpportunityScreen() = SearchOpportunityScreen()

    fun getSearchProductsScreen() = SearchProductsScreen()
}