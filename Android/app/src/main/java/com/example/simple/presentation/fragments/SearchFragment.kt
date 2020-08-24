package com.example.simple.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.fragment.app.Fragment
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState
import br.com.zup.beagle.android.view.custom.OnStateChanged
import com.example.simple.R
import kotlinx.android.synthetic.main.activity_app_beagle.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchView()
    }

    private fun setupSearchView() {
        search_view.setOnQueryTextFocusChangeListener(object : SearchView.OnQueryTextListener, View.OnFocusChangeListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                text_not_found.visibility = View.GONE
                if (query.isNullOrBlank()) {
                    query?.let {
                        when {
                            it.contains("oportunidade") -> {
                                title.text = "Oportunidades"
                                openScreen("/opportunity")
                            }
                            it.contains("produto") -> {
                                title.text = "Produtos"
                                openScreen("/product")
                            }
                            it.contains("loja") -> {
                                title.text = "Lojas"
                                openScreen("/store")
                            }
                            it.contains("serviço") -> {
                                title.text = "Serviços"
                                openScreen("/service")
                            }
                            else -> {
                                text_not_found.visibility = View.VISIBLE
                                progress_bar.visibility = View.GONE
                            }
                        }
                    }
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onFocusChange(v: View?, hasFocus: Boolean) {

            }
        })
        search_view.isIconified = false
    }

    private fun openScreen(path: String) {
        fl_search.removeAllViewsInLayout()
        fl_search.loadView(this, ScreenRequest("/search$path"),
                object :
                        OnStateChanged {
                    override fun invoke(state: BeagleViewState) {
                        when (state) {
                            is BeagleViewState.LoadStarted -> {
                                pb_search.visibility = View.VISIBLE
                            }
                            is BeagleViewState.LoadFinished -> {
                                pb_search.visibility = View.GONE
                            }
                            is BeagleViewState.Error -> {
                                state.throwable.printStackTrace()
                            }
                        }
                    }

                })
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}