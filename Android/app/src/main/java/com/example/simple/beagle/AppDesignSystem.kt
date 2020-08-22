package com.example.simple.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.DesignSystem
import com.example.simple.R
import com.example.simple.constants.*

@BeagleComponent
class AppDesignSystem : DesignSystem() {

    override fun image(id: String): Int? {
        return when (id) {
            REGISTER -> R.drawable.ic_lista
            LOGO -> R.drawable.image_logo
            PRODUCT -> R.drawable.ic_product
            SERVICE -> R.drawable.ic_service
            MARKETING -> R.drawable.ic_marketing_digital
            ACORDO -> R.drawable.ic_acordo
            VENDAS -> R.drawable.ic_vendas
            SUPPORT -> R.drawable.ic_customer_support
            ADDRESS -> R.drawable.ic_map
            else -> android.R.drawable.ic_menu_help
        }
    }

    override fun toolbarStyle(id: String): Int? {
        return when (id) {
            STYLE_NAVIGATION_BAR -> R.style.Design_NaviagtionBar_Default
            else -> null
        }
    }

    override fun textStyle(id: String): Int? {
        return when(id){
            STYLE_TEXT_BOLD_SYSTEM_20 -> R.style.Style_Text_Bold_System_20
            STYLE_TEXT_NORMAL_SYSTEM_16 -> R.style.Style_Text_Normal_System_16
            else -> null
        }
    }

    override fun buttonStyle(id: String): Int? {
        return when(id){
           STYLE_BUTTON_WHITE_SYSTEM_BOLD_16 -> R.style.Style_Button_White_System_Bold_16
            else -> null
        }
    }

    override fun inputTextStyle(id: String): Int? {
        return when(id){
            STYLE_TEXT_INPUT -> R.style.Style_TextInput
            else -> null
        }
    }
}