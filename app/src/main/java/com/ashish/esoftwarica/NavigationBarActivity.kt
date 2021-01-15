package com.ashish.esoftwarica

import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ashish.esoftwarica.ui.aboutus.AboutusFragment
import com.ashish.esoftwarica.ui.addstudent.AddStudentFragment
import com.ashish.esoftwarica.ui.home.HomeFragment

class NavigationBarActivity : AppCompatActivity() {
    private lateinit var btmnavview:BottomNavigationView
    private lateinit var linearconainer: LinearLayout
    var lstStudent = ArrayList<student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        btmnavview=findViewById(R.id.nav_view)
        linearconainer=findViewById(R.id.nav_host_fragment)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, HomeFragment())
            addToBackStack(null)
            commit()
        }
        btmnavview.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, HomeFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.navigation_addstudent -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, AddStudentFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.navigation_aboutus -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, AboutusFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
        loadStudent()
    }
    private fun loadStudent() {
        lstStudent.add(student(0, "Ashish Bhantana", "Kathmandu", "22", "https://miro.medium.com/max/1200/1*mk1-6aYaf_Bes1E3Imhc0A.jpeg","Male"))
    }
}

