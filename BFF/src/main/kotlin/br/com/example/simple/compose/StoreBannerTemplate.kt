package br.com.example.simple.compose

import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath

class StoreBannerTemplate(
        val banner: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Container(children = listOf(
                Image(path = ImagePath.Local.justMobile(banner), mode = ImageContentMode.CENTER_CROP).applyStyle(
                        style = Style(
                                size = Size(width = 100.unitPercent(), height = 200.unitReal()),
                                margin = EdgeValue(top = 10.unitReal()))),
                Touchable(
                        onPress = listOf(
                                Navigate.OpenExternalURL(url = "https://www.instagram.com")
                        ),
                        child = Image(path = ImagePath.Local.justMobile("instagram")).applyStyle(style = Style(
                                size = Size(height = 35.unitReal(), width = 35.unitReal()),
                                positionType = PositionType.ABSOLUTE,
                                position = EdgeValue(bottom = 5.unitReal(), right = 5.unitReal())))),
                Touchable(
                        onPress = listOf(
                                Navigate.OpenExternalURL(url = "https://www.whatsapp.com")
                        ),
                        child = Image(path = ImagePath.Local.justMobile("whatsapp")).applyStyle(style = Style(
                                size = Size(height = 35.unitReal(), width = 35.unitReal()),
                                positionType = PositionType.ABSOLUTE,
                                position = EdgeValue(bottom = 5.unitReal(), right = 50.unitReal()))))
        )
        )
    }
}