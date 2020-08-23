package br.com.example.simple.compose

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.STYLE_TEXT_BOLD_SYSTEM_16
import br.com.example.simple.constants.WHITE
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class ButtonPost(val text: String, val showWhatsAppIcon: Display, val action: Action) : ComposeComponent {
    override fun build() = Container(
            children = listOf(
                    Touchable(
                            onPress = listOf(action),
                            child = Container(
                                    children = listOf(
                                            Image(
                                                    ImagePath.Local.justMobile("whatsapp")
                                            ).applyStyle(
                                                    Style(
                                                            margin = EdgeValue(left = 5.unitReal()),
                                                            size = Size(width = 30.unitReal(), height = 30.unitReal()),
                                                            flex = Flex(alignSelf = AlignSelf.CENTER),
                                                            display = showWhatsAppIcon
                                                    )
                                            ),
                                            Text(
                                                    text,
                                                    styleId = STYLE_TEXT_BOLD_SYSTEM_16,
                                                    textColor = WHITE
                                            ).applyStyle(
                                                    Style(
                                                            flex = Flex(alignSelf = AlignSelf.CENTER)
                                                    )
                                            ),
                                    )
                            ).applyStyle(Style(backgroundColor = BLUE,
                                    size = Size(width = 70.unitPercent(), height = 40.unitReal()),
                                    cornerRadius = CornerRadius(radius = 30.0),
                                    flex = Flex(
                                            flexDirection = FlexDirection.ROW,
                                            justifyContent = JustifyContent.SPACE_AROUND,
                                            alignSelf = AlignSelf.CENTER
                                    )
                            ))
                    )
            )
    )
}