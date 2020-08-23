package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonDefaultCompose
import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

object ProfileScreen: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(title = "Perfil", styleId = STYLE_NAVIGATION_BAR),
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                child = Container(children =
                listOf(
                        profileContainer,
                        profileOptions
                    )
                )
        )
    }

    private val userInfoContainer = Container(children =
        listOf(
                Text(text = "Gabriela Coelho", styleId = STYLE_TEXT_H1, textColor = BLUE, alignment = TextAlignment.LEFT),
                Text(text = "gabrielacoelho@gmail.com", styleId = STYLE_TEXT_SYSTEM_LIGHT, textColor = BLUE, alignment = TextAlignment.LEFT),
                Button(
                        text =  "Editar Perfil",
                        styleId = STYLE_BUTTON_BORDER,
                        onPress = listOf(
                                Navigate.OpenNativeRoute(route = "")
                        )
                ).applyStyle(style = Style(
                        size = Size(width = 50.unitPercent(), height = 20.unitPercent()),
                        margin = EdgeValue(top = 10.unitReal()),
                        cornerRadius = CornerRadius(radius = 10.0),
                        backgroundColor = LIGHT_BACKGROUND
                )
                )
        )).applyStyle(style = Style(
            margin = EdgeValue(left = 10.unitReal())
    ))

    private val profileContainer = Container(children = listOf(
            Image(path = ImagePath.Local.justMobile("perfil")).applyStyle(
                    style = Style(
                            size = Size(width = 100.unitReal(), height = 100.unitReal()),
                            cornerRadius = CornerRadius(50.0))
            ),
            userInfoContainer
        )
    ).applyStyle(style = Style(
            margin = EdgeValue(left = 15.unitReal(), top = 30.unitReal()),
            flex = Flex(flexDirection = FlexDirection.ROW)
    ))

    private val buttonMinhaLoja = ButtonDefaultCompose(
            textButton = "Minha Loja",
            action = Navigate.PushStack(route = Route.Remote(url = "/store")),
            nameIcon = LOJA,
            displayView = Display.FLEX
    ).build()

    private val buttonMeusProdutos = ButtonDefaultCompose(
            textButton = "Meus Produtos",
            action = Navigate.PushStack(route = Route.Remote(url = "/products")),
            nameIcon = PRODUCT,
            displayView = Display.FLEX
    ).build()

    private val buttonPublicacoes = ButtonDefaultCompose(
            textButton = "Minhas Publicações",
            action = Navigate.PushStack(route = Route.Remote(url = "/publicacoes")),
            nameIcon = PUBLICACOES,
            displayView = Display.NONE
    ).build()

    private val profileOptions = Container(
            children =
            listOf(
                    buttonMinhaLoja,
                    buttonMeusProdutos,
                    buttonPublicacoes
            )
    ).applyStyle(style = Style(
            margin = EdgeValue(horizontal = 15.unitReal(),top = 10.unitReal()),
            cornerRadius = CornerRadius(20.0),
            backgroundColor = WHITE,
            padding = EdgeValue(horizontal = 20.unitReal(),vertical = 10.unitReal())
    )
    )



}