package br.com.example.simple.compose

import br.com.example.simple.constants.LIGHT_GREY
import br.com.example.simple.constants.STYLE_TEXT_NORMAL_SYSTEM_16
import br.com.example.simple.constants.STYLE_TEXT_SYSTEM_LIGHT
import br.com.example.simple.constants.WHITE
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class ReviewTemplate(
        val image: String,
        val name: String,
        val review: String
) : ComposeComponent {

    override fun build(): ServerDrivenComponent {

        return Container(children =
        listOf(
                Image(path = ImagePath.Local.justMobile(image), mode = ImageContentMode.FIT_XY)
                        .applyStyle(style = Style(
                                size = Size(width = 80.unitReal(), height = 80.unitReal()),
                                cornerRadius = CornerRadius(radius = 35.0))),
                Container(children =
                listOf(
                        Text(text = name, styleId = STYLE_TEXT_NORMAL_SYSTEM_16, textColor = LIGHT_GREY)
                                .applyStyle(style = Style(
                                        margin = EdgeValue(top = 5.unitReal(), left = 10.unitReal()))),
                        Text(text = review, styleId = STYLE_TEXT_SYSTEM_LIGHT, textColor = LIGHT_GREY)
                                .applyStyle(style = Style(
                                        margin = EdgeValue(top = 5.unitReal(), left = 10.unitReal())))
                )
                )
        )).applyStyle(
                style = Style(
                        backgroundColor = WHITE,
                        margin = EdgeValue(left = 10.unitReal(), right = 10.unitReal(), top = 10.unitReal()),
                        size = Size(width = 310.unitReal(), height = 100.unitReal()),
                        flex = Flex(flexDirection = FlexDirection.ROW, alignSelf = AlignSelf.CENTER),
                        cornerRadius = CornerRadius(radius = 20.0)
                ))
    }
}