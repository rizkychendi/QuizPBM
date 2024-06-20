package com.example.quispbm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val inputDataFragment = InputDataFragment()
    private val biodataDeveloperFragment = BiodataDeveloperFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_input_data -> {
                    setCurrentFragment(inputDataFragment)
                    true
                }
                R.id.nav_biodata -> {
                    setCurrentFragment(biodataDeveloperFragment)
                    true
                }
                else -> false
            }
        }

        // Set the initial fragment
        setCurrentFragment(inputDataFragment)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }
}
