package br.com.example.simple.builder

import br.com.example.simple.constants.BLUE
import br.com.example.simple.constants.LIGHT_GREY
import br.com.example.simple.constants.WHITE
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.pager.PageIndicator
import br.com.zup.beagle.widget.ui.Text

class OnboardingScreenBuilder : ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                child = Container(
                        children = listOf(
                                PageView(
                                        pageIndicator = PageIndicator(
                                                numberOfPages = 3,
                                                selectedColor = BLUE,
                                                unselectedColor = LIGHT_GREY,
                                                currentPage = expressionOf("@{numberPage}")
                                        ),
                                        children = listOf(
                                                page1,
                                                page2,
                                                page3
                                        ),
                                        onPageChange = listOf(SetContext("numberPage", "@{onPageChange}")),
                                        currentPage = expressionOf("@{numberPage}")
                                ),
                                PageIndicator(
                                        numberOfPages = 3,
                                        selectedColor = BLUE,
                                        unselectedColor = LIGHT_GREY,
                                        currentPage = expressionOf("@{numberPage}")
                                )
                        ),
                        context = ContextData("numberPage", 0)
                ).applyStyle(style = Style(
                        flex = Flex(grow = 1.0)
                        )
                )
        )
    }

    val page1 = Container(
            children = listOf(
                    Text(text = "Page 1")
            )
    ).applyStyle(style = Style(
            flex = Flex(grow = 1.0)
    )
    )

    val page2 = Container(
            children = listOf(
                    Text(text = "Page 2")
            )
    ).applyStyle(style = Style(
            flex = Flex(grow = 1.0)
    )
    )

    val page3 = Container(
            children = listOf(
                    Text(text = "Page 3")
            )
    ).applyStyle(style = Style(
            flex = Flex(grow = 1.0)
             )
    )
}