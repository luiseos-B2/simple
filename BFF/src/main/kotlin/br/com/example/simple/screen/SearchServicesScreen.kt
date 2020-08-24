package br.com.example.simple.screen

import br.com.example.simple.action.OpenWhatsApp
import br.com.example.simple.compose.ButtonPost
import br.com.example.simple.compose.PostsCardTemplate
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.layout.ScrollView

class SearchServicesScreen : ScreenBuilder {

    override fun build() = Screen(
            child = ScrollView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            PostsCardTemplate(
                                                    title = "Hebe Camargo",
                                                    location = "São Paulo - SP",
                                                    imageUrl = "http://assets.izap.com.br/terral.agr.br/uploads/img582cb3f65140e.jpg",
                                                    subtitle = "Preciso de alguém pra aparar a grama",
                                                    description = "Moro sozinha, já tenho 75 anos e a grama esta alta preciso de alguém para aparar." +
                                                            " Quem estiver interessado favor entrar em contato",
                                                    button = createButtonWhatsapp()

                                            ),
                                            PostsCardTemplate(
                                                    title = "Luciano Huck",
                                                    location = "Rio de Janeiro - RJ",
                                                    imageUrl = "https://www.eletricista.srv.br/wp-content/uploads/2019/04/como-descobrir-curto-circuito.jpg",
                                                    subtitle = "Preciso de um eletricista para consertar tomadas",
                                                    description = "Duas tomadas pararam de funcionar e uma quero mudar de 110v para 220v." +
                                                            " Por favor preciso com urgência.",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Juliana Paes",
                                                    location = "Rio Bonito - RJ",
                                                    imageUrl = "https://i0.statig.com.br/bancodeimagens/9s/ei/h3/9seih3nlora0ol31r338gwdyu.jpg",
                                                    subtitle = "Preciso de alguém pra passear com meu cãozinho",
                                                    description = "Trabalho muito e tenho percebido meu cão estressado. " +
                                                            " Preciso de alguém para dar uma voltinha com ele duas vezes na semana.",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "Marinete",
                                                    location = "Uberlândia - MG ",
                                                    imageUrl = "https://www.dicasdemulher.com.br/wp-content/uploads/2017/06/erros-mais-comuns-passar-roupa.jpg",
                                                    subtitle = "Preciso de uma passadeira",
                                                    description = "Odeio passar roupas e meu marido trabalha vestindo roupa social." +
                                                            " Preciso de uma passadeira com experiência para trabalhar uma vez por semana",
                                                    button = createButtonWhatsapp()
                                            ),
                                            PostsCardTemplate(
                                                    title = "William Bonner",
                                                    location = "São Paulo - SP",
                                                    imageUrl = "https://negociosmaringa.com/files/clientes/produtos/imagens/24_Manutencao_em_Calhas_Sujas_fazemos_toda_limpeza_do_seu_telhado_JPG.JPG",
                                                    subtitle = "Preciso de alguém que limpe a calha",
                                                    description = "Trabalho apresentando um telejornal e não tenho tempo de limpar..." +
                                                            " Quando a calha tá muito suja a água não escoa. Se for bom o serviço fico freguês.",
                                                    button = createButtonWhatsapp()
                                            )

                                    )
                            )
                    )
            )
    )

    private fun createButtonWhatsapp() = ButtonPost("Quero entrar em contato", Display.FLEX, OpenWhatsApp())
}