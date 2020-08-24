package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonPost
import br.com.example.simple.compose.PostsCardTemplate
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.layout.*

class SearchServicesScreen : ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(title = "Serviços", styleId = STYLE_NAVIGATION_BAR),
            child = ScrollView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            PostsCardTemplate(
                                                    title = "Hebe Camargo",
                                                    location = "B. Esperança - Uberlândia (MG)",
                                                    imageUrl = "http://assets.izap.com.br/terral.agr.br/uploads/img582cb3f65140e.jpg",
                                                    subtitle = "Preciso de alguém pra aparar a grama",
                                                    description = "Moro sozinha, já tenho 75 anos e a grama esta alta preciso de alguém para aparar." +
                                                            " Quem estiver interessado favor entrar em contato",
                                                    button = createButtonWhatsapp()

                                            ),
                                            PostsCardTemplate(
                                                    title = "Luciano Huck",
                                                    location = "B. Glória - Uberlândia (MG)",
                                                    imageUrl = "https://www.eletricista.srv.br/wp-content/uploads/2019/04/como-descobrir-curto-circuito.jpg",
                                                    subtitle = "Preciso de um eletricista para consertar tomadas",
                                                    description = "Duas tomadas pararam de funcionar e uma quero mudar de 110v para 220v." +
                                                            " Por favor preciso com urgência.",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Juliana Paes",
                                                    location = "B. Lagoinha - Uberlândia (MG)",
                                                    imageUrl = "https://i0.statig.com.br/bancodeimagens/9s/ei/h3/9seih3nlora0ol31r338gwdyu.jpg",
                                                    subtitle = "Preciso de alguém pra passear com meu cãozinho",
                                                    description = "Trabalho muito e tenho percebido meu cão estressado. " +
                                                            " Preciso de alguém para dar uma voltinha com ele duas vezes na semana.",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Marinete",
                                                    location = "B. Morumbi - Uberlândia - MG",
                                                    imageUrl = "https://www.dicasdemulher.com.br/wp-content/uploads/2017/06/erros-mais-comuns-passar-roupa.jpg",
                                                    subtitle = "Preciso de uma passadeira",
                                                    description = "Odeio passar roupas e meu marido trabalha vestindo roupa social." +
                                                            " Preciso de uma passadeira com experiência para trabalhar uma vez por semana",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "William Bonner",
                                                    location = "B. Taiaman - Uberlândia - MG",
                                                    imageUrl = "https://negociosmaringa.com/files/clientes/produtos/imagens/24_Manutencao_em_Calhas_Sujas_fazemos_toda_limpeza_do_seu_telhado_JPG.JPG",
                                                    subtitle = "Preciso de alguém que limpe a calha",
                                                    description = "Trabalho apresentando um telejornal e não tenho tempo de limpar..." +
                                                            " Quando a calha tá muito suja a água não escoa. Se for bom o serviço viro freguês.",
                                                    button = createButtonWhatsapp()
                                            )

                                    )
                            )
                    )
            )
    )

    private fun createButtonWhatsapp() = ButtonPost("Quero entrar em contato", Display.FLEX,
            Navigate.OpenExternalURL(url = "https://api.whatsapp.com/send?phone=5534992569623&text=Simple"))
}