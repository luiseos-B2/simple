package br.com.example.simple.compose

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.STYLE_BUTTON_WHITE_SYSTEM_BOLD_16
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button

class ButtonRegisterFlow(val text: String, val route: Route) : ComposeComponent {

    override fun build() = Container(
            children = listOf(Button(
                    text = text,
                    styleId = STYLE_BUTTON_WHITE_SYSTEM_BOLD_16,
                    onPress = listOf(
                            Navigate.PushView(route = route)
                    )
            ).applyStyle(style = Style(
                    size = Size(width = 65.unitPercent(), height = 15.unitPercent()),
                    margin = EdgeValue(all = 10.unitReal()),
                    cornerRadius = CornerRadius(radius = 10.0),
                    flex = Flex(alignSelf = AlignSelf.CENTER),
                    backgroundColor = BLUE)
            )
            )
    ).applyStyle(Style(
            flex = Flex(alignItems = AlignItems.CENTER,
                    justifyContent = JustifyContent.CENTER,
                    grow = 1.0)
    )
    )
}