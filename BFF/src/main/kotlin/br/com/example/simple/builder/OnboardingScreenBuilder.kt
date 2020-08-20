package br.com.example.simple.builder

import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

class OnboardingScreenBuilder: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                child = Container(
                        children = listOf(
                                Text("Hello Beagle").applyFlex(flex = Flex(alignSelf = AlignSelf.CENTER))
                        )
                ).applyFlex(flex = Flex(grow = 1.0,justifyContent = JustifyContent.CENTER))
        )
    }
}