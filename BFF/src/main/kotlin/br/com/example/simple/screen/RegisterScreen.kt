package br.com.example.simple.screen

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.TextInput

data class User(
        val name: String,
        val surname: String,
        val email: String,
        val password: String,
        val confirmPassword: String
)

class RegisterScreen : ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        title = "Cadastro",
                        showBackButton = true,
                        styleId = STYLE_NAVIGATION_BAR
                ),
                child = Container(
                        children = listOf(
                                imageLogo,
                                createTextInput(
                                        textInputPlaceholder = "Nome",
                                        textInputValue = "@{user.name}",
                                        contextPath = "name"
                                ),
                                createTextInput(
                                        textInputPlaceholder = "Sobrenome",
                                        textInputValue = "@{user.surname}",
                                        contextPath = "surname"
                                ),
                                createTextInput(
                                        textInputPlaceholder = "Email",
                                        textInputValue = "@{user.email}",
                                        contextPath = "email",
                                        type = TextInputType.EMAIL
                                ),
                                createTextInput(
                                        textInputPlaceholder = "Senha",
                                        textInputValue = "@{user.password}",
                                        contextPath = "password"
                                ),
                                createTextInput(
                                        textInputPlaceholder = "Confirmar Senha",
                                        textInputValue = "@{user.confirmPassword}",
                                        contextPath = "confirmPassword"
                                ),
                                buttonNext

                        ),
                        context = ContextData(
                                id = "user",
                                value = User(
                                        name = "",
                                        surname = "",
                                        email = "",
                                        password = "",
                                        confirmPassword = ""
                                )
                        )
                ).applyFlex(Flex(grow = 1.0, alignItems = AlignItems.CENTER))
        )
    }

    private val buttonNext = Container(
            children = listOf(
                    Button(
                            "Próximo",
                            STYLE_BUTTON_WHITE_SYSTEM_BOLD_16,
                            onPress = listOf(
                                    Navigate.PushView(route = Route.Remote(url = "/address"))
                            )
                    ).applyStyle(
                            Style(
                                    backgroundColor = BLUE,
                                    cornerRadius = CornerRadius(10.0),
                                    size = Size(width = 50.unitPercent(), height = 15.unitPercent()),
                                    margin = EdgeValue(
                                            bottom = 30.unitReal()
                                    ),
                                    flex = Flex(alignSelf = AlignSelf.CENTER)
                            )
                    )
            )
    ).applyFlex(Flex(justifyContent = JustifyContent.CENTER,grow = 1.0))

    private val imageLogo = Image(
            ImagePath.Local.justMobile(REGISTER)
    ).applyStyle(
            Style(
                    flex = Flex(alignSelf = AlignSelf.CENTER),
                    size = Size(80.unitReal(),80.unitReal()),
                    margin = EdgeValue(vertical = 30.unitReal())
            )
    )

    private fun createTextInput(
            textInputPlaceholder: String,
            textInputValue: String,
            contextPath: String,
            type: TextInputType? = null
    ): TextInput = TextInput(
            placeholder = textInputPlaceholder,
            value = textInputValue,
            type = type,
            styleId = STYLE_TEXT_INPUT,
            onChange = listOf(
                    SetContext(
                            contextId = "user",
                            path = contextPath,
                            value = "@{onChange.value}"
                    )
            )
    ).applyStyle(
            Style(
                    size = Size(width = 85.unitPercent(), height = 5.unitPercent()),
                    margin = EdgeValue(top = 20.unitReal())
            )
    )
}