package br.com.example.simple.controller

import br.com.example.simple.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchController(
        private val searchService: SearchService
) {

    @RequestMapping("/service")
    @GetMapping
    fun getSearchServices() = this.searchService.getSearchServicesScreen()

    @RequestMapping("/store")
    @GetMapping
    fun getSearchStore() = this.searchService.getSearchStoreScreen()

    @RequestMapping("/opportunity")
    @GetMapping
    fun getSearchOpportunity() = this.searchService.getSearchOpportunityScreen()

    @RequestMapping("/product")
    @GetMapping
    fun getSearchProducts() = this.searchService.getSearchProductsScreen()
}