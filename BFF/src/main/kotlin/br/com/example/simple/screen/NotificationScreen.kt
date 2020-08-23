package br.com.example.simple.screen

import br.com.example.simple.compose.NotificationTemplateCompose
import br.com.example.simple.constants.LIGHT_BACKGROUND
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.layout.*

object NotificationScreen: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                navigationBar = NavigationBar(
                        "Notificações",
                        showBackButton = true,
                        styleId = STYLE_NAVIGATION_BAR
                ),
                child = Container(
                        children = listOf(
                                notification
                        )
                ).applyFlex(flex = Flex(grow = 1.0))
        )
    }

    private val notification = ScrollView(
            scrollBarEnabled = false,
            children = listOf(
                    NotificationTemplateCompose(
                            title = "Bem Vindo",
                            mensage = "Seja bem-vindo, colega! Desejamos que você se sinta bem entre nós, que faça parte das nossas vivências, que encontre oportunidades e condições para aprender e crescer. ... Esperamos sinceramente que a sua experiência conosco seja excelente e duradoura."
                    ),
                    NotificationTemplateCompose(
                            title = "Dia do Trabalhador",
                            mensage = "Todo trabalho honesto sustenta, honra e dignifica o ser humano. Feliz Dia do Trabalho! Parabéns trabalhador! Pela força, coragem e dedicação em fazer um trabalho digno e de extrema importância."
                    ),
                    NotificationTemplateCompose(
                            title = "Dia do Comerciante",
                            mensage = "Quando vendemos nossa mercadoria, fazemos mais do que trocar ideias ou diminuir barreiras… Nós criamos desenvolvimento e buscamos novas amizades! O comércio é um grande impulsionador da sociedade, sem dúvida! Feliz dia do comerciante!"
                    )
            )
    )
}