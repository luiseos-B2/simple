package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonPost
import br.com.example.simple.compose.PostsCardTemplate
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.layout.*

class SearchProductsScreen : ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(title = "Produtos", styleId = STYLE_NAVIGATION_BAR),
            child = ScrollView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            PostsCardTemplate(
                                                    title = "Perfumaria Silva",
                                                    location = "B. Santa Mônica - Uberlândia - MG",
                                                    imageUrl = "https://cdn.awsli.com.br/600x450/596/596667/produto/29772334/perfume-chanel-chance-edp-feminino-100ml-072538d9.jpg",
                                                    subtitle = "Perfume Chanel Chance EDP Feminino 100ml",
                                                    priceText = "R$ 255,99",
                                                    description = "Com o Eau de Parfum, CHANCE torna-se mais redondo, mais generoso e mais envolvente ... como novo amor.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Livraria B1",
                                                    location = "Centro - Uberlândia - MG",
                                                    imageUrl = "https://images-submarino.b2w.io/produtos/imagens/6719447/6719448_1GG.jpg",
                                                    subtitle = "Livro - A Cabana - Capa Filme - William P. Young",
                                                    priceText = "R$ 43,99",
                                                    description = "A qualidade de A Cabana é inquestionável! O livro é best-seller mundial, vendeu mais de 4 milhões de exemplares no Brasil.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Eletrônicos Basso",
                                                    location = "B. São Jorge - Uberlândia - MG",
                                                    imageUrl = "https://images-americanas.b2w.io/produtos/01/00/img/1754124/8/1754124827_1SZ.jpg",
                                                    subtitle = "Fone de Ouvido Bluetooth Xiaomi Redmi Airdots",
                                                    priceText = "R$ 244,72",
                                                    description = "Redução de ruído inteligente: a unidade dinâmica de 7,2 mm e a redução de ruído do ambiente inteligente DSP.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Relojoaria Coelho",
                                                    location = "B. Luizote - Uberlândia - MG",
                                                    imageUrl = "https://images-americanas.b2w.io/produtos/01/00/images/79597/8/79597872_1SZ.jpg",
                                                    subtitle = "Relógio Masculino Preto Black Motion Design Quartz",
                                                    priceText = "R$ 88,99",
                                                    description = "Excelente RELÓGIO, Ideal Para Quem Busca Um Modelo VERSÁTIL.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Doceria Silva",
                                                    location = "B. Luizote - Uberlândia - MG",
                                                    imageUrl = "https://img.itdg.com.br/tdg/images/recipes/000/081/014/72081/72081_original.jpg?mode=crop&width=710&height=400",
                                                    subtitle = "Bolo Floresta Negra",
                                                    priceText = "R$ 59,99",
                                                    description = "A sobremesa consiste em algumas camadas de bolo de chocolate com creme de chantili e cerejas em cada camada.",
                                                    button = createButtonStore()
                                            )

                                    )
                            )
                    )
            )
    )

    private fun createButtonStore() = ButtonPost("Ir para a loja", Display.NONE, Navigate.PushView(route = Route.Remote(url = "/store")))
}