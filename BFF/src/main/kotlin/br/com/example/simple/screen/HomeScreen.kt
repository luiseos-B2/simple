package br.com.example.simple.screen

import br.com.example.simple.compose.CategoryTemplate
import br.com.example.simple.compose.ProductCardTemplate
import br.com.example.simple.constants.*
import br.com.zup.beagle.builder.widget.size
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

object HomeScreen : ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                safeArea = SafeArea(top = false),
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                child = ScrollView(
                children = listOf(
                    Text(text = "Categorias", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                            margin = EdgeValue(top = 5.unitReal())
                        )
                    ),
                    categoriesList,
                    Text(text = "Oportunidades", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    ),
                    opportunitiesList,
                    Text(text = "Serviços", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    ),
                    opportunitiesList,
                    Text(text = "Produtos perto de você", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    ),
                    products
                )
            )
        )
    }

    private val banner = Touchable(
            onPress = listOf(
                    Navigate.PushView(route = Route.Remote(url = "/store"))
            ),
            child = Image(path = ImagePath.Local.justMobile("banner")).applyStyle(
                style = Style(
                        size = Size(width = 300.unitReal(), height = 200.unitReal()),
                        margin = EdgeValue(right = 20.unitReal())
                )
         )
    )
    private val opportunitiesList = ScrollView(
            scrollBarEnabled = false,
            scrollDirection = ScrollAxis.HORIZONTAL,
            children = listOf(
                    banner,
                    banner,
                    banner,
                    banner,
                    banner,
                    banner,
                    banner
            )
    )
    private val categoriesList = Container(
            children = listOf(
                    CategoryTemplate(text = "Produtos", image = "productsicon"),
                    CategoryTemplate(text = "Lojas", image = "shop"),
                    CategoryTemplate(text = "Serviços", image = "services"),
                    CategoryTemplate(text = "Oportunidade", image = "opportunity1")
            )
    ).applyStyle(style = Style(
            flex = Flex(flexDirection = FlexDirection.ROW),
            margin = EdgeValue(top = 5.unitReal())
        )
    )

    private val products = ScrollView(
            scrollBarEnabled = false,
            children = listOf(
                    ProductCardTemplate(image = "product4", priceText = "R$ 7.80", productName = "Batom Basic 01 VulT", description = "Super confortável nos lábios, o Batom Basic da Vult proporciona uma boa cobertura e um acabamento cremoso. Fácil de espalhar e em textura leve, o batom garante lábios com cores sensacionais."),
                    ProductCardTemplate(image = "product1", priceText = "R$ 10.00", productName = "Camisa Feminina Baby Look Billie Eilish", description = "\n" +
                            "Tecido: 100%algodão fio 30.1\n" + "\n" +  "ESTAMPA: SUBLIMAÇÃO E VINIL EMBORRACHADO\n" +  "\n" +
                            "Qualidade do Tecido, Estampa e Costura.\n" + "\n" + "Excelente custo beneficio, preço baixo e qualidade!\n" + "\n" +
                            "baby look Super confortável, Tecido leve ideal para treinos e Lazer aos finais de semana.\n"),
                    ProductCardTemplate(image = "product2", priceText = "R$ 20.00", productName = "Camisa Adidas Feminina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tBABY LOOK\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" +
                            "Gênero: Feminino\n" + "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductCardTemplate(image = "product3", priceText = "R$ 7.00", productName = "Camisa Adidas Masculina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tCamiseta\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" + "Gênero: Masculino\n" +
                            "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductCardTemplate(image = "product5", priceText = "R$ 76.00", productName = "Colônia Moto Soul 100ml", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tUomini Desodorante Colônia Moto Soul 100ml\n" +
                            "Versão\tMoto Soul\n" + "Gênero\tMasculino\n" + "Tipo\tDes. Colônia\n" + "Volume da unidade\t100 mL"),
                    ProductCardTemplate(image = "product6", priceText = "R$ 90.00", productName = "Kit Flower De Floratta\n", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tFloratta\n" + "Gênero\tFeminino\n" + "Tipo\tColônia\n" + "Volume da unidade\t90 mL")
            )
    )
}