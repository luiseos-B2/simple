package br.com.example.simple.compose

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.STYLE_BUTTON_BORDER
import br.com.example.simple.constants.STYLE_TEXT_BOLD_SYSTEM_20
import br.com.example.simple.constants.STYLE_TEXT_SYSTEM_LIGHT
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text


class TipsTemplate(val title: String, val text: String, val image: String, val buttonText: String = "", val displayImage: Display, val displayButton: Display, val url: String = "") : ComposeComponent {
    override fun build() = Container(
            children = listOf(
                    Text(
                            title,
                            STYLE_TEXT_BOLD_SYSTEM_20,
                            textColor = BLUE
                    ).applyStyle(
                            Style(
                                    margin = EdgeValue(
                                            top = 10.unitPercent()
                                    ),
                                    flex = Flex(alignSelf = AlignSelf.CENTER)
                            )
                    ),
                    Text(
                            text,
                            STYLE_TEXT_SYSTEM_LIGHT,
                            textColor = BLUE
                    ).applyStyle(
                            Style(
                                    margin = EdgeValue(
                                            top = 5.unitPercent(),
                                            horizontal = 10.unitReal()
                                    ),
                                    flex = Flex(alignSelf = AlignSelf.CENTER)
                            )
                    ),
                    createImage(
                            name = image,
                            displayImage = displayImage,
                            margin = EdgeValue(top = 5.unitReal()),
                            flex = Flex(alignSelf = AlignSelf.CENTER),
                            positionType = PositionType.RELATIVE
                    ),
                    Button(text = buttonText, styleId = STYLE_BUTTON_BORDER, onPress = listOf(
                            Navigate.OpenExternalURL(url = url)
                    )).applyStyle(style = Style(
                            display = displayButton,
                            size = Size(width = 150.unitReal()),
                            flex = Flex(alignSelf = AlignSelf.CENTER),
                            cornerRadius = CornerRadius(10.0)
                    ))
            )
    ).applyStyle(Style(flex = Flex(grow = 1.0)))

    fun createImage(
            name: String,
            margin: EdgeValue,
            flex: Flex,
            positionType: PositionType,
            displayImage: Display = Display.FLEX
    ) = Image(
            ImagePath.Remote(remoteUrl = name)
    ).applyStyle(
            Style(
                    display = displayImage,
                    size = Size(width = 80.unitPercent(), height = 40.unitPercent()),
                    margin = margin,
                    positionType = positionType,
                    flex = flex
            )
    )

}