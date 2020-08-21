package br.com.example.simple.screen

import br.com.example.simple.compose.PageOnboardingTemplate
import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.LIGHT_GREY
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.pager.PageIndicator
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath

class OnboardingScreen : ScreenBuilder {

    val flexGrow = Flex(grow = 1.0)

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

    val imageLogo = Image(
            ImagePath.Local.justMobile("Logo")
    ).applyStyle(
            Style(
                    margin = EdgeValue(
                            top = 15.unitPercent()
                    ),
                    flex = Flex(alignSelf = AlignSelf.CENTER)
            )
    )

    val page1 = createPage(
            text = "Agora já pode usar o aplicativo para procurar prestadores de serviços ou produtos!",
            firstImage = "Product",
            secondImage = "Service",
            nameButton = "Pular",
            actionButton = SetContext("numberPage", 2),
            displayButton = Display.FLEX
    )

    val page2 = createPage(
            text = "Procurar serviços, oferecer servicos para pessoas do seu bairro!",
            firstImage = "Product",
            secondImage = "Service",
            nameButton = "",
            actionButton = SetContext("",""),
            displayButton = Display.NONE
    )

    val page3 = createPage(
            text = "Tudo isso em um só aplicativo, juntando todos comercios e prestadores de servicos em um só lugar!",
            firstImage = "Product",
            secondImage = "Service",
            nameButton = "Proximo",
            actionButton = SetContext("numberPage", 2),
            displayButton = Display.FLEX
    )

    val pageView = PageView(
            children = listOf(
                    page1,
                    page2,
                    page3
            ),
            onPageChange = listOf(SetContext("numberPage", "@{onPageChange}")),
            currentPage = expressionOf("@{numberPage}")
    )


    val pageIndicator = PageIndicator(
            numberOfPages = 3,
            selectedColor = BLUE,
            unselectedColor = LIGHT_GREY,
            currentPage = expressionOf("@{numberPage}")
    )

    fun createPage(
            text: String,
            firstImage: String,
            secondImage: String,
            nameButton: String,
            actionButton: Action,
            displayButton: Display
    ) = Container(
            children = listOf(
                    imageLogo,
                    PageOnboardingTemplate(
                            text = text,
                            firstImage = firstImage,
                            secondImage = secondImage
                    ).build(),
                    createbutton(nameButton, actionButton, displayButton)
            )
    ).applyFlex(flexGrow)

    fun createbutton(text: String, action: Action, displayButton: Display) = Button(
            text,
            "styleButtonWhiteSystemSemibold",
            onPress = listOf(
                    action
            )
    ).applyStyle(
            Style(
                    backgroundColor = BLUE,
                    cornerRadius = CornerRadius(10.0),
                    size = Size(width = 25.unitPercent(), height = 40.unitReal()),
                    display = displayButton,
                    margin = EdgeValue(
                            right = 15.unitReal(),
                            bottom = 15.unitReal()
                    ),
                    flex = Flex(
                            alignSelf = AlignSelf.FLEX_END,
                            justifyContent = JustifyContent.FLEX_END
                    )
            )
    )


}