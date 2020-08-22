package br.com.example.simple.screen

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
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
                        profileContainer
                    )
                )
        )
    }

    private val userInfoContainer = Container(children =
        listOf(
                Text(text = "José João junior", styleId = STYLE_TEXT_H1, textColor = BLUE, alignment = TextAlignment.LEFT),
                Text(text = "jjj@gmail.com", styleId = STYLE_TEXT_SYSTEM_LIGHT, textColor = BLUE, alignment = TextAlignment.LEFT)
        )).applyStyle(style = Style(
            margin = EdgeValue(left = 10.unitReal()),
            size = Size(width = 60.unitPercent())
    ))

    private val profileContainer = Container(children = listOf(
            Image(path = ImagePath.Local.justMobile("imageBeagle")).applyStyle(
                    style = Style(
                            size = Size(width = 100.unitReal(), height = 100.unitReal()),
                            cornerRadius = CornerRadius(50.0))
            ),
            userInfoContainer
        )
    ).applyStyle(style = Style(
            margin = EdgeValue(left = 20.unitReal(), top = 30.unitReal()),
            size = Size(width = 100.unitPercent(), height = 200.unitReal()),
            flex = Flex(flexDirection = FlexDirection.ROW)
    ))

    private val option = Container(children =
        listOf(
                Image(path = ImagePath.Local.justMobile("menu")).applyStyle(
                        style = Style(size = Size(width = 30.unitReal(), height = 30.unitReal()))
                ),
                Text(text = "Minha Loja", styleId = STYLE_TEXT_SYSTEM_LIGHT, textColor = BLUE, alignment = TextAlignment.LEFT).applyStyle(style = Style(
                        margin = EdgeValue(left = 20.unitReal(), right = 140.unitReal())
                )),
                Image(path = ImagePath.Local.justMobile("menu")).applyStyle(
                        style = Style(
                                size = Size(width = 30.unitReal(), height = 30.unitReal())
                        )
                )
        )
    ).applyStyle(style = Style(
            margin = EdgeValue(left = 30.unitReal(), right = 30.unitReal(), top = 5.unitReal()),
            size = Size(height = 50.unitReal()),
            flex = Flex(flexDirection = FlexDirection.ROW),
            backgroundColor = WHITE
    ))


    private val profileOptions = Container(children =
    listOf(
            option,
            option,
            option,
            option
    )
    ).applyStyle(style = Style(
            margin = EdgeValue(left = 30.unitReal(), right = 30.unitReal()),
            size = Size(height = 200.unitReal()),
            cornerRadius = CornerRadius(20.0),
            backgroundColor = WHITE
    ))
}