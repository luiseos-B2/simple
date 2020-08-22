package br.com.example.simple.screen

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.*
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.*

data class Address(val data: Data)

data class Data(
        val cep: String,
        val rua: String,
        val numero: String,
        val bairro: String,
        val cidade: String,
        val estado: String,
        val complemento: String
)

object AddressScreen : ScreenBuilder {

    var styleMargin = Style(
            margin = EdgeValue(
                    top = 15.unitReal(),
                    left = 25.unitReal(),
                    right = 25.unitReal()
            )
    )

    override fun build() = Screen(
            navigationBar = NavigationBar(
                    title = "Cadastro Endereço",
                    styleId = STYLE_NAVIGATION_BAR,
                    showBackButton = true
            ),
            child = Container(
                    children = listOf(
                            imageAddress,
                            textInputZip,
                            textsInput,
                            button
                    ),
                    context = ContextData(
                            id = "address",
                            value = Address(
                                    data = Data(
                                            cep = "",
                                            rua = "",
                                            numero = "",
                                            bairro = "",
                                            cidade = "",
                                            estado = "",
                                            complemento = ""
                                    )
                            )
                    )
            ).applyFlex(Flex(grow = 1.0))
    )

    private val imageAddress = Image(
            ImagePath.Local.justMobile(ADDRESS)
    ).applyStyle(
            Style(
                    margin = EdgeValue(top = 5.unitReal()),
                    flex = Flex(alignSelf = AlignSelf.CENTER),
                    size = Size(width = 25.unitPercent(), height = 25.unitPercent())
            )
    )

    private val textInputZip = TextInput(
            placeholder = "Cep",
            value = "@{address.data.cep}",
            styleId = STYLE_TEXT_INPUT,
            type = TextInputType.NUMBER,
            onChange = listOf(
                    SetContext(
                            contextId = "address",
                            path = "data.cep",
                            value = "@{onChange.value}"
                    )
            ),
            onBlur = listOf(
                    SendRequest(
                            url = "https://viacep.com.br/ws/@{onBlur.value}/json",
                            method = RequestActionMethod.GET,
                            onSuccess = listOf(
                                    SetContext(
                                            contextId = "address",
                                            path = "data",
                                            value = Data(
                                                    cep = "@{onBlur.value}",
                                                    rua = "@{onSuccess.data.logradouro}",
                                                    numero = "@{address.data.number}",
                                                    bairro = "@{onSuccess.data.bairro}",
                                                    cidade = "@{onSuccess.data.localidade}",
                                                    estado = "@{onSuccess.data.uf}",
                                                    complemento = "@{address.data.complement}"
                                            )
                                    )
                            )
                    )
            )
    ).applyStyle(styleMargin)

    private val textsInput = Container(
            children = listOf(
                    createTextInput(
                            textInputPlaceholder = "Rua",
                            textInputValue = "@{address.data.rua}",
                            contextPath = "data.rua"
                    ),
                    createTextInput(
                            textInputPlaceholder = "Numero",
                            textInputValue = "@{address.data.numero}",
                            contextPath = "data.numero",
                            type = TextInputType.NUMBER
                    ),
                    createTextInput(
                            textInputPlaceholder = "Bairro",
                            textInputValue = "@{address.data.bairro}",
                            contextPath = "data.bairro"
                    ),
                    createTextInput(
                            textInputPlaceholder = "Cidade",
                            textInputValue = "@{address.data.cidade}",
                            contextPath = "data.cidade"
                    ),
                    createTextInput(
                            textInputPlaceholder = "Estado",
                            textInputValue = "@{address.data.estado}",
                            contextPath = "data.estado"
                    ),
                    createTextInput(
                            textInputPlaceholder = "Complemento",
                            textInputValue = "@{address.data.complemento}",
                            contextPath = "data.complemento"
                    )
            )
    )

    private val button = Container(
            children = listOf(
                    Button(
                            "Enviar",
                            STYLE_BUTTON_WHITE_SYSTEM_BOLD_16,
                            onPress = listOf(
                                    Alert(
                                            title = "Sucesso!",
                                            message = "Cadastro realizado com sucesso!",
                                            onPressOk = Navigate.PushView(route = Route.Remote(url = "/home"))
                                    ),
                                    SetContext(
                                            contextId = "address",
                                            path = "data",
                                            value =
                                            Data(
                                                    cep = "",
                                                    rua = "",
                                                    numero = "",
                                                    bairro = "",
                                                    cidade = "",
                                                    estado = "",
                                                    complemento = ""
                                            )
                                    )
                            )
                    ).applyStyle(
                            Style(
                                    backgroundColor = BLUE,
                                    cornerRadius = CornerRadius(10.0),
                                    size = Size(width = 25.unitPercent(), height = 40.unitReal()),
                                    margin = EdgeValue(
                                            right = 15.unitReal(),
                                            bottom = 15.unitReal()
                                    ),
                                    flex = Flex(
                                            alignSelf = AlignSelf.CENTER
                                    )
                            )
                    )
            )
    ).applyFlex(Flex(justifyContent = JustifyContent.CENTER, grow = 1.0))


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
                            contextId = "address",
                            path = contextPath,
                            value = "@{onChange.value}"
                    )
            )
    ).applyStyle(styleMargin)
}