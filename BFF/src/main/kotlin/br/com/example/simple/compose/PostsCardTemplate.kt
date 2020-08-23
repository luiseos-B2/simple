package br.com.example.simple.compose

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class PostsCardTemplate(
        val imageUrl: String,
        val priceText: String? = null,
        val title: String,
        val location: String,
        val subtitle: String,
        val description: String,
        val button : ButtonPost
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return  Container(children =
        listOf(
                Container(children =
                listOf(
                        Container(
                                children = listOf(
                                        Text(text = title, styleId = STYLE_TEXT_BOLD_SYSTEM_16,
                                                alignment = TextAlignment.LEFT, textColor = BLUE),
                                        Text(text = " - $location", styleId = STYLE_TEXT_SYSTEM_LIGHT,
                                                alignment = TextAlignment.LEFT, textColor = LIGHT_GREY)
                                )
                        ).applyFlex(Flex(flexDirection = FlexDirection.ROW, alignItems = AlignItems.CENTER)),
                        Image(
                                ImagePath.Local.justMobile("share")
                        ).applyStyle(
                                Style(
                                        flex = Flex(alignSelf = AlignSelf.CENTER),
//                                        position = EdgeValue(right = 20.unitReal()),
                                        size = Size(width = 25.unitReal(), height = 25.unitReal())
                                )
                        )
                )).applyStyle(Style(
                        size = Size(width = 100.unitPercent()),
                        flex = Flex(flexDirection = FlexDirection.ROW,
                                alignItems = AlignItems.CENTER,
                                justifyContent = JustifyContent.SPACE_BETWEEN),
                        padding = EdgeValue(
                                top = 5.unitReal(),
                                bottom = 10.unitReal(),
                                right = 10.unitReal(),
                                left =  10.unitReal()
                        ))),
                Container(
                        children = listOf(
                                Image(path = ImagePath.Remote(imageUrl))
                                        .applyStyle(style = Style(
                                                size = Size(width = 100.unitPercent(), 300.unitReal()),
                                                flex = Flex(
                                                        alignSelf = AlignSelf.CENTER
                                                )
                                        )
                                        )
                        )
                ).applyStyle(style = Style(
                        size = Size(width = 100.unitPercent(), height = 275.unitReal()),
                        flex = Flex(
                                alignSelf = AlignSelf.CENTER
                        )
                )
                ),
                Text(text = subtitle, styleId = STYLE_TEXT_BOLD_SYSTEM_16,
                        alignment = TextAlignment.LEFT, textColor = BLUE)
                        .applyStyle(
                                Style(
                                        margin = EdgeValue(
                                                all = 10.unitReal())
                                )),
                createPriceFieldText(priceText),
                Text(text = description, styleId = STYLE_TEXT_SYSTEM_LIGHT, alignment = TextAlignment.LEFT, textColor = BLACK).applyStyle(
                        Style(margin = EdgeValue(
                                all = 10.unitReal())
                        )),
                button,
                Container(
                        children = listOf(

                        )
                ).applyStyle(
                        Style(
                                backgroundColor = BLUE,
                                margin = EdgeValue(
                                        horizontal = 5.unitReal(),
                                        top = 20.unitReal()
                                ),
                                size = Size(height = 1.unitReal()),
                                display = Display.FLEX
                        )
                )
        )
        ).applyStyle(style = Style(
                size = Size(width = 100.unitPercent()),
                margin = EdgeValue(top = 5.unitReal(), bottom = 5.unitReal()),
                flex = Flex(
                        alignSelf = AlignSelf.CENTER
                )
        )
        )
    }

    private fun createPriceFieldText(priceText: String? = null): Text {
        priceText?.let {
            return Text(text = it, styleId = STYLE_TEXT_BOLD_SYSTEM_20, alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                    margin = EdgeValue(all = 10.unitReal())
            ))
        }
        return Text(text = "").applyStyle(style = Style(display = Display.NONE))
    }
}