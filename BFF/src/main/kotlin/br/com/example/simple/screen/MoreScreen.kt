package br.com.example.simple.screen

import br.com.example.simple.compose.ButtonDefaultCompose
import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder

import br.com.zup.beagle.widget.ui.Text

object MoreScreen: ScreenBuilder {
    override fun build(): Screen {
        return  return Screen(
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                child = Container(
                        children = listOf(
                                textTitle,
                                profileOptions
                        )
                )
        )
    }

    private val textTitle = Text(
            "Menu",
            textColor = BLUE,
            styleId = STYLE_TEXT_H1
    ).applyStyle(
            Style(
                    margin = EdgeValue(
                            top = 20.unitReal(),
                            left = 20.unitReal()
                    )
            )
    )

    private val buttonDicas = ButtonDefaultCompose(
            textButton = "Dicas de Negócios",
            action = Navigate.PushStack(route = Route.Remote(url = "/dicas")),
            nameIcon = DICAS,
            displayView = Display.FLEX
    ).build()

    private val buttonPolicyPrivacy = ButtonDefaultCompose(
            textButton = "Política de Privacidade",
            action = Navigate.PushStack(route = Route.Remote(url = "/policy")),
            nameIcon = POLICY,
            displayView = Display.FLEX
    ).build()

    private val buttonNotification = ButtonDefaultCompose(
            textButton = "Notificações",
            action = Navigate.PushStack(route = Route.Remote(url = "/notification")),
            nameIcon = NOTIFICATION,
            displayView = Display.FLEX
    ).build()

    private val buttonLegalInformation = ButtonDefaultCompose(
            textButton = "Informações Legais",
            action = Navigate.PushStack(route = Route.Remote(url = "/information")),
            nameIcon = INFORMATION,
            displayView = Display.FLEX
    ).build()

    private val buttonExit = ButtonDefaultCompose(
            textButton = "Sair",
            action = Navigate.ResetStack(route = Route.Remote(url = "/login")),
            nameIcon = EXIT,
            displayView = Display.NONE
    ).build()

    private val profileOptions = Container(
            children =
            listOf(
                    buttonDicas,
                    buttonNotification,
                    buttonPolicyPrivacy,
                    buttonLegalInformation,
                    buttonExit

            )
    ).applyStyle(style = Style(
            margin = EdgeValue(horizontal = 15.unitReal(),top = 30.unitReal()),
            cornerRadius = CornerRadius(20.0),
            backgroundColor = WHITE,
            padding = EdgeValue(horizontal = 20.unitReal(),vertical = 10.unitReal())
            )
    )
}