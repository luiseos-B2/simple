package com.example.simple.action

import android.content.Intent
import android.net.Uri
import android.view.View
import br.com.zup.beagle.android.action.Action
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.annotation.RegisterAction
import com.example.simple.constants.URL_WHATSAPP_DEFAULT

@RegisterAction
class OpenWhatsApp : Action {

    override fun execute(rootView: RootView, origin: View) {
        rootView.getContext().startActivity(
                Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(URL_WHATSAPP_DEFAULT)
                )
        )
    }
}