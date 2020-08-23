package br.com.example.simple.compose

import br.com.example.simple.constants.DARK_BLUE
import br.com.example.simple.constants.STYLE_TEXT_SYSTEM_LIGHT
import br.com.zup.beagle.core.CornerRadius
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

class CategoryTemplate(
        val text: String,
        val image: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Container(children =
        listOf(
                Touchable(
                        onPress = listOf(
                                Navigate.PushView(route = Route.Remote(url = "/search"))
                        ),
                        child = Image(path = ImagePath.Local.justMobile(image), mode = ImageContentMode.FIT_CENTER).applyStyle(
                                style = Style(
                                        size = Size(width = 80.unitPercent(), height = 85.unitReal()),
                                        margin = EdgeValue(left = 10.unitReal(), right = 10.unitReal()),
                                        cornerRadius = CornerRadius(radius = 42.5)

                                )
                        )
                ),
                Text(text = text, alignment = TextAlignment.CENTER, styleId = STYLE_TEXT_SYSTEM_LIGHT, textColor = DARK_BLUE)
            )
        )
    }
}