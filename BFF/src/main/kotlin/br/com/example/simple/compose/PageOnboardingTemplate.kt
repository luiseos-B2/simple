package br.com.example.simple.compose

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.STYLE_TEXT_BOLD_SYSTEM_20
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class PageOnboardingTemplate(val text: String, val firstImage: String, val secondImage: String) : ComposeComponent {
    override fun build() = Container(
            children = listOf(
                    Text(
                            text,
                            STYLE_TEXT_BOLD_SYSTEM_20,
                            textColor = BLUE
                    ).applyStyle(
                            Style(
                                    margin = EdgeValue(
                                            top = 15.unitPercent(),
                                            horizontal = 20.unitReal()
                                    ),
                                    flex = Flex(alignSelf = AlignSelf.CENTER)
                            )
                    ),
                    Container(
                            children = listOf(
                                    createImage(
                                            name = firstImage,
                                            margin = EdgeValue(right = 15.unitReal()),
                                            flex = Flex( alignSelf = AlignSelf.FLEX_END),
                                            positionType = PositionType.RELATIVE
                                    ),
                                    createImage(
                                            name = secondImage,
                                            margin = EdgeValue(left = 15.unitReal()),
                                            flex = Flex( alignSelf = AlignSelf.FLEX_START),
                                            positionType = PositionType.ABSOLUTE
                                    )
                            )).applyStyle(Style(margin = EdgeValue(top = 15.unitPercent())))
            )
    ).applyStyle(Style(flex = Flex(grow = 1.0)))

    fun createImage(
            name: String,
            margin: EdgeValue,
            flex: Flex,
            positionType: PositionType
    ) = Image(
            ImagePath.Local.justMobile(name)
    ).applyStyle(
            Style(
                    size = Size(width = 55.unitPercent(), height = 55.unitPercent()),
                    margin = margin,
                    positionType = positionType,
                    flex = flex
            )
    )

}