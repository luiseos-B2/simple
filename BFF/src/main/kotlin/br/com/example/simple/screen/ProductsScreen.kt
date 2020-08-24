package br.com.example.simple.screen

import br.com.example.simple.compose.ProductEditCardTemplate
import br.com.example.simple.constants.LIGHT_BACKGROUND
import br.com.example.simple.constants.MAIS
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.ImagePath

object ProductsScreen : ScreenBuilder {

    val navigationBarItem = NavigationBarItem(
            text = "",
            image = ImagePath.Local.justMobile(MAIS),
            action = Alert(
                    title = "Atenção",
                    message = "Tela não criada!"
            )
    )

    override fun build(): Screen {
        return Screen(
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                navigationBar = NavigationBar(
                        "Produtos",
                        styleId = STYLE_NAVIGATION_BAR,
                        showBackButton = true,
                        navigationBarItems = listOf(navigationBarItem)
                ),
                child = Container(
                        children = listOf(
                                products
                        )
                )
        )
    }

    private val products = ScrollView(
            scrollBarEnabled = false,
            children = listOf(
                    ProductEditCardTemplate(image = "product4", priceText = "R$ 7.80", productName = "Batom Basic 01 VulT", description = "Super confortável nos lábios, o Batom Basic da Vult proporciona uma boa cobertura e um acabamento cremoso. Fácil de espalhar e em textura leve, o batom garante lábios com cores sensacionais."),
                    ProductEditCardTemplate(image = "product1", priceText = "R$ 10.00", productName = "Camisa Feminina Baby Look Billie Eilish", description = "\n" +
                            "Tecido: 100%algodão fio 30.1\n" + "\n" + "ESTAMPA: SUBLIMAÇÃO E VINIL EMBORRACHADO\n" + "\n" +
                            "Qualidade do Tecido, Estampa e Costura.\n" + "\n" + "Excelente custo beneficio, preço baixo e qualidade!\n" + "\n" +
                            "baby look Super confortável, Tecido leve ideal para treinos e Lazer aos finais de semana.\n"),
                    ProductEditCardTemplate(image = "product2", priceText = "R$ 20.00", productName = "Camisa Adidas Feminina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tBABY LOOK\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" +
                            "Gênero: Feminino\n" + "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductEditCardTemplate(image = "product3", priceText = "R$ 7.00", productName = "Camisa Adidas Masculina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tCamiseta\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" + "Gênero: Masculino\n" +
                            "Material principal: 100%ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductEditCardTemplate(image = "product5", priceText = "R$ 76.00", productName = "Colônia Moto Soul 100ml", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tUomini Desodorante Colônia Moto Soul 100ml\n" +
                            "Versão\tMoto Soul\n" + "Gênero\tMasculino\n" + "Tipo\tDes. Colônia\n" + "Volume da unidade\t100 mL"),
                    ProductEditCardTemplate(image = "product6", priceText = "R$ 90.00", productName = "Kit Flower De Floratta\n", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tFloratta\n" + "Gênero\tFeminino\n" + "Tipo\tColônia\n" + "Volume da unidade\t90 mL")
            )
    )

}