package br.com.example.simple.screen

import br.com.zup.beagle.builder.widget.size
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class CategorySelector(
        val text: String,
        val image: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Container(children =
        listOf(
            Touchable(
                onPress = listOf(
                    Navigate.PushView(route = Route.Remote(url = ""))
                ),
                child = Image(path = ImagePath.Local.justMobile(image), mode = ImageContentMode.FIT_CENTER).applyStyle(
                                style = Style(
                                        size = Size(width = 85.unitReal(), height = 85.unitReal()),
                                        margin = EdgeValue(left = 10.unitReal(), right = 10.unitReal()),
                                        cornerRadius = CornerRadius(radius = 42.5)

                                )
                        )
                ),
                Text(text = text, alignment = TextAlignment.CENTER, styleId = "Style.Text.Blue")
            )
        )
    }
}

object HomeScreen : ScreenBuilder {
    override fun build(): Screen {
        return Screen(navigationBar = NavigationBar(title = "Simple"),
                child = ScrollView(
                children = listOf(
                    Text(text = "Categorias", styleId = "Style.H1.Text").applyStyle(style = Style(
                            margin = EdgeValue(top = 5.unitReal())
                        )
                    ),
                    categoriesList,
                    Text(text = "Oportunidades", styleId = "Style.H1.Text").applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    ),
                    opportunitiesList,
                    Text(text = "Serviços", styleId = "Style.H1.Text").applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    ),
                    opportunitiesList,
                    Text(text = "Produtos perto de você", styleId = "Style.H1.Text").applyStyle(style = Style(
                            margin = EdgeValue(top = 10.unitReal())
                        )
                    )
                )
            )
        )
    }

    private val banner = Touchable(
            onPress = listOf(
                    Navigate.PushView(route = Route.Remote(url = ""))
            ),
            child = Image(path = ImagePath.Local.justMobile("banner")).applyStyle(
                style = Style(
                        size = Size(width = 300.unitReal(), height = 200.unitReal()),
                        margin = EdgeValue(right = 20.unitReal())
                )
         )
    )
    private val opportunitiesList = ScrollView(
            scrollBarEnabled = false,
            scrollDirection = ScrollAxis.HORIZONTAL,
            children = listOf(
                    banner,
                    banner,
                    banner,
                    banner,
                    banner,
                    banner,
                    banner
            )
    )
    private val categoriesList = Container(
            children = listOf(
                    CategorySelector(text = "Produtos", image = "imageBeagle"),
                    CategorySelector(text = "Lojas", image = "imageBeagle"),
                    CategorySelector(text = "Serviços", image = "imageBeagle"),
                    CategorySelector(text = "Oportunidade", image = "imageBeagle")
            )
    ).applyStyle(style = Style(
            flex = Flex(flexDirection = FlexDirection.ROW),
            margin = EdgeValue(top = 5.unitReal())
        )
    )

}