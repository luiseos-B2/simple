package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonPost
import br.com.example.simple.compose.PostsCardTemplate
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.layout.*

class SearchStoreScreen : ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(title = "Lojas", styleId = STYLE_NAVIGATION_BAR),
            child = ScrollView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            PostsCardTemplate(
                                                    title = "Doceria Pires",
                                                    location = "B. Tabajaras - Uberlândia (MG)",
                                                    imageUrl = "https://www.melecanacozinha.com/wp-content/uploads/2016/06/neg%C3%B3cio-de-doces.jpg",
                                                    subtitle = "Faça sua vida mais doce",
                                                    description = "Aceitamos encomendas em pequenas quantidade na quarentena. Temos serviço de entrega.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Brechó",
                                                    location = "Centro - Uberlândia (MG)",
                                                    imageUrl = "https://oimparcial.com.br/app/uploads/2019/10/brechos-em-goiania-8-excelentes-opcoes-para-economizar-1024x683.jpg",
                                                    subtitle = "Você sempre na moda",
                                                    description = "Temos roupas novas e seminovas a partir de R$ 30,00.",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Eletrônicos Basso",
                                                    location = "B. Aclimação - Uberlândia (MG)",
                                                    imageUrl = "https://gd-argentina.sfo2.cdn.digitaloceanspaces.com/2020/01/loja-merlin-electronica-bariloche-1.jpg",
                                                    subtitle = "Tudo que você precisa pelo menor preço",
                                                    description = "Estamos a 5 anos oferecendo atendimento de qualidade e ótimos produtos",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Cosméticos Udão",
                                                    location = "B. Brasil - Uberlândia (MG)",
                                                    imageUrl = "https://leonidasherndl.com.br/wp-content/uploads/2017/08/cosmeticos-quimicas2.jpg",
                                                    subtitle = "Os melhores produtos pra você ficar bem",
                                                    description = "Promoção em produtos para tratamentos capilares e tinturas",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Relojoaria Coelho",
                                                    location = "B. Luizote - Uberlândia (MG)",
                                                    imageUrl = "https://revistadestaquemais.com.br/wp-content/uploads/2017/10/Inca-%C3%93tica-e-Relojoaria-4-1.jpg",
                                                    subtitle = "Sempre no tempo certo",
                                                    description = "Os relógios mais lindos pra você não perder a hora",
                                                    button = createButtonStore()
                                            )

                                    )
                            )
                    )
            )
    )

    private fun createButtonStore() = ButtonPost("Ir para a loja", Display.NONE, Navigate.PushView(route = Route.Remote(url = "/store")))
}