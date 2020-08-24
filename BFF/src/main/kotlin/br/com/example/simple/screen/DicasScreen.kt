package br.com.example.simple.screen

import br.com.example.simple.compose.TipsTemplate
import br.com.example.simple.constants.*
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.pager.PageIndicator
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath


object DicasScreen: ScreenBuilder {
    private val flexGrow = Flex(grow = 1.0)

    override fun build(): Screen {
        return Screen(
                child = Container(
                        children = listOf(
                                pageView,
                                pageIndicator
                        ),
                        context = ContextData("numberPage", 0)
                ).applyStyle(Style(
                        flex = Flex(grow = 1.0)
                )
                )
        )
    }

    private val imageLogo = Image(
            ImagePath.Local.justMobile(LOGO)
    ).applyStyle(
            Style(
                    margin = EdgeValue(top = 10.unitPercent()),
                    flex = Flex(alignSelf = AlignSelf.CENTER),
                    size = Size(width = 50.unitPercent(), height = 10.unitPercent())
            )
    )

    private val page1 = createPage(
            text = "Se você possui uma loja e ainda não possui um instagram para a sua loja, indicamos fortemente que você crie um!\n" +
                    "O Instagram com uma conta comercial abre um leque de ferramentas estratégicas," +
                    "em que é possível verificar informações como localização, faixa etária e gênero de seu público." +
                    "\nUm perfil comercial ainda permite patrocinar posts e aumentar a visibilidade de sua marca.\n" + "\n",
            image = "https://blog.mxcursos.com/wp-content/uploads/2018/11/a-importancia-do-instagram-no-marketing-digital-e-5-dicas-para-se-destacar-nesta-rede_social.png",
            title = "Olá, Gabriela!"
    )

    private val page2 = createPage(
            title = "Benefícios:",
            text = "Baixo investimento inicial, você não paga nada para criar uma conta para sua empresa no Instagram. E para começar uma campanha paga, o investimento mínimo pode ser entre \$1 e \$5, divididos entre diário e vitalício.\n" +
                    "\n" +
                    "Clique no botão para ir para um post \nonde nós explicamos com mais detalhes quanto custa anunciar no Instagram." + "\n",
            url = "https://www.linksexperts.com.br/blog/quanto-custa-anunciar-no-instagram/",
            buttonText = "Ir para post",
            displayButton = Display.FLEX,
            displayImage = Display.NONE
    )

    private val page3 = createPage(
            title = "Relação do usuário com empresas:",
            text = "Pensando em negócios no Instagram, uma pesquisa dita que 83% dos entrevistados segue alguma empresa ou marca na rede social.\n" +
                    "\n" + "Entre todos esses usuários, 48% dizem ainda já ter comprado algum produto ou contratado algum serviço que conheceu no Instagram. \nEm paralelo, 47% compraram algo que foi indicado por alguém no Instagram.",
            image = "https://blog.opinionbox.com/wp-content/uploads/2019/07/img_resultado_pesquisa_instagram_17_07_19_v01.png"
    )

    private val pageView = PageView(
            children = listOf(
                    page1,
                    page2,
                    page3
            ),
            onPageChange = listOf(SetContext("numberPage", "@{onPageChange}")),
            currentPage = expressionOf("@{numberPage}")
    )

    private val pageIndicator = PageIndicator(
            numberOfPages = 3,
            selectedColor = BLUE,
            unselectedColor = LIGHT_GREY,
            currentPage = expressionOf("@{numberPage}")
    )

    private fun createPage(
            title: String,
            text: String,
            image: String = "",
            buttonText: String = "",
            url: String = "",
            displayButton: Display = Display.NONE,
            displayImage: Display = Display.FLEX
    ) = Container(
            children = listOf(
                    imageLogo,
                    TipsTemplate(
                            title = title,
                            text = text,
                            image = image,
                            url = url,
                            displayButton = displayButton,
                            displayImage = displayImage,
                            buttonText = buttonText
                    ).build()
            )
    ).applyFlex(flexGrow)
}