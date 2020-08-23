package br.com.example.simple.compose

import br.com.example.simple.constants.STYLE_TEXT_NORMAL_SYSTEM_16
import br.com.zup.beagle.builder.widget.size
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.core.TextAlignment
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class ServicesBannerTemplate (
        val textColor: String,
        val image: String,
        val description: String
): ComposeComponent{
    override fun build(): ServerDrivenComponent {
        return Touchable(
                onPress = listOf(
                        Navigate.PushView(route = Route.Remote(url = "/store"))
                ),
                child = Container(children = listOf(
                        Image(path = ImagePath.Local.justMobile(image), mode = ImageContentMode.CENTER_CROP).applyStyle(
                                style = Style(
                                        size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                        margin = EdgeValue(right = 20.unitReal())
                                )
                        ),
                        Text(text = description, textColor = textColor, styleId = STYLE_TEXT_NORMAL_SYSTEM_16, alignment = TextAlignment.CENTER).applyStyle(
                                style = Style(positionType = PositionType.ABSOLUTE, position = EdgeValue(top = 5.unitReal(), left = 5.unitReal()))
                        ),
                        Touchable(
                                onPress = listOf(
                                        Navigate.OpenExternalURL(url = "https://www.whatsapp.com")
                                ),
                                child = Image(path = ImagePath.Local.justMobile("whatsapp")).applyStyle(style = Style(
                                        size = Size(height = 35.unitReal(), width = 35.unitReal()),
                                        positionType = PositionType.ABSOLUTE,
                                        position = EdgeValue(bottom = 5.unitReal(), right = 5.unitReal())))),
                )).applyStyle(
                        style = Style(
                                margin = EdgeValue(left = 10.unitReal()),
                                size = Size(width = 250.unitReal(), height = 150.unitReal()),
                                cornerRadius = CornerRadius(radius = 20.0)
                        )
                )
        )
    }
}