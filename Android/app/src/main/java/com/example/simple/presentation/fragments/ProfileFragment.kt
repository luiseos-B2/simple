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
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenProfile()
    }

    private fun screenProfile() {
        fl_profile.removeAllViewsInLayout()
        fl_profile.loadView(this, ScreenRequest("/profile"),
            object :
                OnStateChanged {
                override fun invoke(state: BeagleViewState) {
                    when (state){
                        is BeagleViewState.LoadStarted -> {
                            pb_profile.visibility = View.VISIBLE
                        }
                        is BeagleViewState.LoadFinished -> {
                            pb_profile.visibility = View.GONE
                        }
                        is BeagleViewState.Error -> {
                            state.throwable.printStackTrace()
                        }
                    }
                }

            })
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }

}