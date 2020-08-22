package br.com.example.simple.compose

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.DARK_BLUE
import br.com.example.simple.constants.LIGHT_GREY
import br.com.example.simple.constants.WHITE
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
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

class ProductCardTemplate(
        val image: String,
        val priceText: String,
        val productName: String,
        val description: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Touchable(onPress = listOf(Navigate.PushView(route = Route.Remote(url = "/profile"))), child =
            Container(children =
                listOf(
                        Image(path = ImagePath.Local.justMobile(image))
                                .applyStyle(style = Style(
                                        margin = EdgeValue(top = 10.unitReal()),
                                        size = Size(width = 200.unitReal(), height = 200.unitReal()),
                                        cornerRadius = CornerRadius(50.0),
                                        flex = Flex(
                                                alignSelf = AlignSelf.CENTER
                                        )
                                    )
                                ),
                        Text(text = productName, styleId = "Style.Text.System.Light", alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                                 margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                            )
                        ),
                        Text(text = priceText, styleId = "Style.Text.System.Light", alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                                margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                        )),
                        Text(text = description, styleId = "Style.Text.System.Light", alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                                margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                        ))
                )
            ).applyStyle(style = Style(
                    margin = EdgeValue(top = 10.unitReal()),
                    size = Size(width = 90.unitPercent(), height = 400.unitReal()),
                    cornerRadius = CornerRadius(20.0),
                    backgroundColor = WHITE,
                    flex = Flex(
                            alignSelf = AlignSelf.CENTER,
                    )
                )
            )
        )
    }
}