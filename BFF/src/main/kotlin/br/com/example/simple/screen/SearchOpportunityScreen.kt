package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonPost
import br.com.example.simple.compose.PostsCardTemplate
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.layout.*

class SearchOpportunityScreen : ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(title = "Oportunidades", styleId = STYLE_NAVIGATION_BAR),
            child = ScrollView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            PostsCardTemplate(
                                                    title = "Doceria Pires",
                                                    location = "B. Tibery - Uberlândia (MG)",
                                                    imageUrl = "https://www.mundosenai.com.br/media/images/shutterstock_1020222631_resized_0V2t4er.jpg",
                                                    subtitle = "Precisamos de confeiteiro",
                                                    description = "Não exigimos experiência. Investimos em cursos e treinamentos",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Brechó",
                                                    location = "Centro - Uberlândia (MG)",
                                                    imageUrl = "https://www.institutobrasileiroalfa.com.br/thumb.php?w=705&h=550&zc=2&src=images/portfolio/ec305a78fa93aba00be1c6958bf0472c.jpg",
                                                    subtitle = "Precisamos de atendente/vendedor",
                                                    description = "Se você gosta de lidar com pessoas e vender essa oportunidade é para você",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Reppuz Hacka",
                                                    location = "B. Finotti - Uberlândia (MG)",
                                                    imageUrl = "https://blog.certisign.com.br/wp-content/uploads/2019/09/dia-do-programador.blog_.jpg",
                                                    subtitle = "Vagas para Desenvolvedores",
                                                    description = "Que tenha conhecimento de linguagens de programação e utilizem boas práticas",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Cosméticos Udão",
                                                    location = "B. Brasil - Uberlândia (MG)",
                                                    imageUrl = "https://maringapost.com.br/wp-content/uploads/2020/05/Auxiliar-de-limpeza-1068x680.jpg",
                                                    subtitle = "Procura-se auxiliar de limpeza",
                                                    description = "Benefícios atraentes como cartão alimentação e plano de saúde sem cooparticipação",
                                                    button = createButtonStore()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Você Bem Estética",
                                                    location = "B. Luizote - Uberlândia (MG)",
                                                    imageUrl = "https://www.belezap.com.br/wp-content/uploads/2019/10/manicure-a-domicilio-confira-passos-para-ter-sucesso-20191024163201.jpg.jpg",
                                                    subtitle = "Precisa-se de Manicure",
                                                    description = "Que tenha pelo menos 3 meses de experiência. Horários flexíveis.",
                                                    button = createButtonStore()
                                            )

                                    )
                            )
                    )
            )
    )

    private fun createButtonStore() = ButtonPost("Contatar para contratação", Display.FLEX,
            Navigate.OpenExternalURL(url = "https://api.whatsapp.com/send?phone=5534992569623&text=Simple"))
}