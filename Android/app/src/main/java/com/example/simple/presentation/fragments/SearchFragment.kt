package com.example.simple.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState
import br.com.zup.beagle.android.view.custom.OnStateChanged
import com.example.simple.R
import com.example.simple.constants.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchView()
    }

    private fun setupSearchView() {
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                title.visibility = View.GONE
                text_not_found.visibility = View.GONE
                if (!newText.isNullOrBlank()) {
                    when {
                        newText.contains(getString(R.string.input_opportunity)) -> {
                            title.text = getString(R.string.opportunity_title)
                            openScreen(OPPORTUNITY_PATH)
                        }
                        newText.contains(getString(R.string.input_product)) -> {
                            title.text = getString(R.string.product_title)
                            openScreen(PRODUCT_PATH)
                        }
                        newText.contains(getString(R.string.input_store)) -> {
                            title.text = getString(R.string.store_title)
                            openScreen(STORE_PATH)
                        }
                        newText.contains(getString(R.string.input_service)) -> {
                            title.text = getString(R.string.service_title)
                            openScreen(SERVICE_PATH)
                        }
                        else -> {
                            text_not_found.visibility = View.VISIBLE
                        }
                    }
                }
                return false
            }
        })
        search_view.isIconified = false
    }

    private fun openScreen(path: String) {
        fl_search.removeAllViewsInLayout()
        fl_search.loadView(this, ScreenRequest(SEARCH_PATH + path),
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