package com.gabe.monop.application

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.gabe.monop.R
import com.gabe.monop.application.modules.contacts.ContactFragment
import com.gabe.monop.application.modules.home.HomeFragment
import com.gabe.monop.application.modules.search.SearchByUFFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val actionBar = supportActionBar

        when (item.itemId) {
            R.id.home_fragment -> {
                setActionBarTitle(actionBar, "MonOp")

                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.search_fragment -> {
                setActionBarTitle(actionBar, "Buscar obras")
                val fragment = SearchByUFFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.contact_fragment -> {
                setActionBarTitle(actionBar, "Contato")
                val fragment = ContactFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.home_fragment
    }

    private fun setActionBarTitle(actionBar: ActionBar?, text: String) {
        actionBar?.let {
            it.title = text
        }
    }
}
