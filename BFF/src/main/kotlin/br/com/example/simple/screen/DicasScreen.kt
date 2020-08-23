package br.com.example.simple.screen

import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

object DicasScreen: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        "Dicas de Negócios",
                        styleId = STYLE_NAVIGATION_BAR
                ),
                child = Container(
                        children = listOf(
                                Text("Implement me")
                        )
                )
        )
    }
}