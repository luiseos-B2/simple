package com.example.simple.beagle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ServerDrivenState
import com.example.simple.R

@BeagleComponent
class AppBeagleActivity : BeagleActivity() {

    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress_bar) }
    private val mToolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.custom_toolbar) }
    private val mButton: Button by lazy { findViewById<Button>(R.id.btn_try_again) }
    private val mFrame: FrameLayout by lazy { findViewById<FrameLayout>(R.id.server_driven_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_beagle)
    }

    override fun getServerDrivenContainerId(): Int = R.id.server_driven_container

    override fun getToolbar(): Toolbar = mToolbar

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
        if (state is ServerDrivenState.Loading) {
            progressBar.visibility = if (state.loading) View.VISIBLE else View.GONE
        } else if (state is ServerDrivenState.Error) {
            mFrame.visibility = View.GONE
            progressBar.visibility = View.GONE
            buttonRetry(state)
        }
    }

    private fun buttonRetry(state: ServerDrivenState.Error){
        mButton.visibility = View.VISIBLE
        mButton.setOnClickListener {
            state.retry()
            mButton.visibility = View.GONE
            mFrame.visibility = View.VISIBLE
        }
    }
}