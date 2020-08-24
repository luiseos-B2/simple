package com.example.simple.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simple.R
import com.example.simple.presentation.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        runNavigation()
    }

    private fun runNavigation() {
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigation.setOnNavigationItemReselectedListener { }
        goToFragment(HomeFragment.newInstance())
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    goToFragment(HomeFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    goToFragment(SearchFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.post -> {
                    goToFragment(PostFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    goToFragment(ProfileFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu -> {
                    goToFragment(MenuFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun goToFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_activity_home, fragment)
        fragmentTransaction.commit()
    }
}