package br.com.example.simple.compose

import br.com.example.simple.constants.LIGHT_GREY
import br.com.example.simple.constants.STYLE_TEXT_BOLD_SYSTEM_20
import br.com.example.simple.constants.STYLE_TEXT_NORMAL_SYSTEM_16
import br.com.example.simple.constants.WHITE
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Text


class NotificationTemplateCompose(
        val title: String,
        val mensage: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Container(
                children = listOf(
                        Text(
                                title,
                                styleId = STYLE_TEXT_BOLD_SYSTEM_20,
                                textColor = LIGHT_GREY
                        ).applyStyle(
                                Style(
                                        flex = Flex(alignSelf = AlignSelf.CENTER),
                                        margin = EdgeValue(horizontal = 10.unitReal(), top = 15.unitReal())
                                )
                        ),
                        Text(
                                mensage,
                                styleId = STYLE_TEXT_NORMAL_SYSTEM_16,
                                textColor = LIGHT_GREY
                        ).applyStyle(
                                Style(
                                        flex = Flex(alignSelf = AlignSelf.CENTER),
                                        margin = EdgeValue(horizontal = 10.unitReal(), bottom = 15.unitReal(), top = 10.unitReal())
                                )
                        )
                )
        ).applyStyle(
                Style(
                        backgroundColor = WHITE,
                        margin = EdgeValue(top = 10.unitReal(), left = 10.unitReal(), right = 10.unitReal()),
                        size = Size(width = 90.unitPercent()),
                        cornerRadius = CornerRadius(20.0),
                        flex = Flex(alignSelf = AlignSelf.CENTER)
                )
        )
    }
}