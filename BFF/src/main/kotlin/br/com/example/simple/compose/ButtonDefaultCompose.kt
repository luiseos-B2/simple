package br.com.example.simple.compose

import br.com.example.simple.constants.BACKBUTTON
import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.STYLE_TEXT_BOLD_SYSTEM_16
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class ButtonDefaultCompose(
        val textButton: String,
        val action: Action,
        val nameIcon: String,
        val displayView: Display
) : ComposeComponent {
    override fun build() = Container(
            children = listOf(
                    Touchable(
                            onPress = listOf(action),
                            child = Container(
                                    children = listOf(
                                            Image(
                                                    ImagePath.Local.justMobile(nameIcon)
                                            ).applyStyle(
                                                    Style(
                                                            size = Size(width = 30.unitReal(), height = 30.unitReal())
                                                    )
                                            ),
                                            Text(
                                                    textButton,
                                                    styleId = STYLE_TEXT_BOLD_SYSTEM_16,
                                                    textColor = BLUE
                                            ).applyStyle(
                                                    Style(
                                                            positionType = PositionType.ABSOLUTE,
                                                            margin = EdgeValue(
                                                                    top = 5.unitReal(),
                                                                    left = 16.unitPercent()
                                                            )
                                                    )
                                            ),
                                            Image(
                                                    ImagePath.Local.justMobile(BACKBUTTON)
                                            ).applyStyle(
                                                    Style(
                                                            size = Size(width = 25.unitReal(), height = 25.unitReal()),
                                                            flex = Flex(alignSelf = AlignSelf.FLEX_END),
                                                            position = EdgeValue(right = 10.unitReal()),
                                                            positionType = PositionType.ABSOLUTE
                                                    )
                                            ),
                                            Container(
                                                    children = listOf(

                                                    )
                                            ).applyStyle(
                                                    Style(
                                                            backgroundColor = BLUE,
                                                            margin = EdgeValue(
                                                                    horizontal = 5.unitReal(),
                                                                    vertical = 10.unitReal()
                                                            ),
                                                            size = Size(height = 1.unitReal()),
                                                            display = displayView
                                                    )
                                            )
                                    )
                            )
                    )
            )
    )
}