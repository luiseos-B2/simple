package br.com.example.simple.screen

import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

object LoginScreen : ScreenBuilder {

    override fun build() = Screen(
            child = Text("Implement me")
    )
}