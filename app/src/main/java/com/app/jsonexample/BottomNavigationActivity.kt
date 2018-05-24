package com.app.jsonexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.app.jsonexample.fragments.OneFragment
import com.app.jsonexample.fragments.ThreeFragment
import com.app.jsonexample.fragments.TwoFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bnOne -> {
                    val fragment = OneFragment.newInstance()
                    addFragment(fragment)
                }

                R.id.bnTwo -> {
                    val fragment = TwoFragment.newInstance()
                    addFragment(fragment)
                }
                R.id.bnThree -> {
                    val fragment = ThreeFragment.newInstance()
                    addFragment(fragment)
                }
                else ->
                    Toast.makeText(this, "Default Fragment", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val fragment = OneFragment.newInstance()
        addFragment(fragment)

    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }
}
