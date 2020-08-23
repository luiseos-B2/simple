package br.com.example.simple.screen

import br.com.example.simple.compose.ProductCardTemplate
import br.com.example.simple.compose.ReviewTemplate
import br.com.example.simple.compose.StoreBannerTemplate
import br.com.example.simple.constants.LIGHT_BACKGROUND
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.*

object StoreScreen: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(title = "Loja", styleId = STYLE_NAVIGATION_BAR),
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                child = Container(children =
                listOf(
                        StoreBannerTemplate(banner = "bannerStore"),
                        Container(children = listOf(oldTab)).applyStyle(
                                style = Style(
                                        backgroundColor = LIGHT_BACKGROUND,
                                        size = Size(width = 100.unitPercent(), height = 100.unitPercent()))))
                )
        )
    }

    private val promotionsBanner = Image(path = ImagePath.Local.justMobile("banner"), mode = ImageContentMode.FIT_CENTER).applyStyle(
            style = Style(
                    size = Size(width = 300.unitReal(), height = 200.unitReal()),
                    margin = EdgeValue(left = 5.unitReal()),
                    flex = Flex(alignSelf = AlignSelf.FLEX_START)
            ))

    private val productsList = ScrollView(
            scrollBarEnabled = false,
            scrollDirection = ScrollAxis.HORIZONTAL,
            children = listOf(
                    ProductCardTemplate(image = "product1", productName = "Camisa Adidas", priceText = "7,90", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tBABY LOOK\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" +
                            "Gênero: Feminino\n" + "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductCardTemplate(image = "product2", priceText = "R$ 20.00", productName = "Camisa Adidas Feminina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tBABY LOOK\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" +
                            "Gênero: Feminino\n" + "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA")
                    )
    )

    private val opportunitiesList = Container(
            children = listOf(
                    ScrollView(
                            scrollBarEnabled = false,
                            scrollDirection = ScrollAxis.HORIZONTAL,
                            children = listOf(
                                    promotionsBanner,
                                    promotionsBanner,
                                    promotionsBanner
                            )
                    )
            )
    ).applyStyle(style = Style(backgroundColor = LIGHT_BACKGROUND, flex = Flex(alignItems = AlignItems.CENTER)))

    private val reviewsList = Container(children =
        listOf(
                ScrollView(
                        scrollBarEnabled = false,
                        children = listOf(
                                ReviewTemplate(
                                        image = "reviewUser",
                                        name = "José João",
                                        review = "Serviço muito bem feito! Com certeza voltarei a entrar em \n" + "contato caso preciso de algo."
                                ),
                                ReviewTemplate(
                                        image = "reviewUser",
                                        name = "Maria Joana ",
                                        review = "Entrega chegou perfeitamente! Material é muito bom"
                                ),
                                ReviewTemplate(
                                        image = "reviewUser",
                                        name = "Marco Augusto",
                                        review = "Muito bom, acabamento perfeito!\n"
                                )
                        )
                )
        )
    ).applyStyle(style = Style(
            backgroundColor = LIGHT_BACKGROUND,
            size = Size(100.unitPercent(), height = 100.unitPercent())
    ))

    private val oldTab = TabView(
            children = listOf(
                    TabItem(title = "Home", child = opportunitiesList),
                    TabItem(title = "Produtos", child = productsList),
                    TabItem(title = "Reviews", child = reviewsList)
            )
    )
}