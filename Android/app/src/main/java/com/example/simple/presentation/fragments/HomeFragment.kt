package com.example.simple.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState
import br.com.zup.beagle.android.view.custom.OnStateChanged
import com.example.simple.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenHome()
    }

    private fun screenHome() {
        fl_home.removeAllViewsInLayout()
        fl_home.loadView(this, ScreenRequest("/home"),
            object :
                OnStateChanged {
                override fun invoke(state: BeagleViewState) {
                    when (state){
                        is BeagleViewState.LoadStarted -> {
                            pb_home.visibility = View.VISIBLE
                        }
                        is BeagleViewState.LoadFinished -> {
                            pb_home.visibility = View.GONE
                        }
                        is BeagleViewState.Error -> {
                            state.throwable.printStackTrace()
                        }
                    }
                }

            })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}