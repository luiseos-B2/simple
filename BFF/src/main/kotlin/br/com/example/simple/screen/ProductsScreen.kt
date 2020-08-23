package br.com.example.simple.screen

import br.com.example.simple.constants.MAIS
import br.com.example.simple.constants.STYLE_NAVIGATION_BAR
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

object ProductsScreen: ScreenBuilder {

    val navigationBarItem = NavigationBarItem(
            text = "",
            image = ImagePath.Local.justMobile(MAIS),
            action = Navigate.PushView(route = Route.Remote(url = "/adicionarProducs"))

    )
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        "Produtos",
                        styleId = STYLE_NAVIGATION_BAR,
                        showBackButton = true,
                        navigationBarItems = listOf(navigationBarItem)
                ),
                child = Container(
                        children = listOf(
                                Text("Implement me")
                        )
                )
        )
    }
}