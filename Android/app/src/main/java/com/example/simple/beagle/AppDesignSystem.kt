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
            OPPORTUNITY -> R.drawable.ic_travel
            SERVICES -> R.drawable.ic_consult
            SHOP -> R.drawable.ic_shop
            PRODUCTSICON -> R.drawable.ic_supermarket
            PRODUCT1 -> R.drawable.product1
            PRODUCT2 -> R.drawable.product2
            PRODUCT3 -> R.drawable.product3
            PRODUCT4 -> R.drawable.product4
            PRODUCT5 -> R.drawable.product5
            PRODUCT6 -> R.drawable.product6
            BANNER -> R.drawable.banner
            LOJA -> R.drawable.ic_loja
            BACKBUTTON -> R.drawable.ic_chevron
            POLICY -> R.drawable.ic_insurance
            NOTIFICATION -> R.drawable.ic_alert
            INFORMATION -> R.drawable.ic_diploma
            EXIT -> R.drawable.ic_remover
            PUBLICACOES -> R.drawable.ic_aparecer
            PROFILE -> R.drawable.profile
            BANNER_STORE -> R.drawable.banner_store
            REVIEW_USER -> R.drawable.review_user
            INSTAGRAN -> R.drawable.instagram
            WHATSAPP -> R.drawable.ic_whatsapp
            BLACK_BANNER -> R.drawable.black_banner
            ORANGE_BANNER -> R.drawable.orange_banner
            YELLOW_BANNER -> R.drawable.yellow_banner
            BLUE_BANNER -> R.drawable.blue_banner
            ORANGE_BANNER2 -> R.drawable.orange_banner2
            DICAS -> R.drawable.ic_profits
            MAIS -> R.drawable.ic_mais
            EDITAR -> R.drawable.ic_editar
            CLEAN_GARDEN -> R.drawable.pessoa
            SHARE_ICON -> R.drawable.ic_share
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
        return when (id) {
            STYLE_TEXT_BOLD_SYSTEM_20 -> R.style.Style_Text_Bold_System_20
            STYLE_TEXT_SYSTEM_BOLD_12 -> R.style.Style_Text_Bold_System_12
            STYLE_TEXT_NORMAL_SYSTEM_16 -> R.style.Style_Text_Normal_System_16
            STYLE_TEXT_H1 -> R.style.Style_H1_Text
            STYLE_TEXT_SYSTEM_LIGHT -> R.style.Style_Text_System_Light
            STYLE_TEXT_BOLD_SYSTEM_16 -> R.style.Style_Text_Bold_System_16
            else -> null
        }
    }

    override fun buttonStyle(id: String): Int? {
        return when (id) {
            STYLE_BUTTON_WHITE_SYSTEM_BOLD_16 -> R.style.Style_Button_White_System_Bold_16
            STYLE_BUTTON_BORDER -> R.style.Style_Border_Blue_System_16
            else -> null
        }
    }

    override fun inputTextStyle(id: String): Int? {
        return when (id) {
            STYLE_TEXT_INPUT -> R.style.Style_TextInput
            else -> null
        }
    }
}