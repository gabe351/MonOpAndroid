package com.gabe.monop.application

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabe.monop.R
import com.gabe.monop.application.modules.contacts.ContactFragment
import com.gabe.monop.application.modules.home.HomeFragment
import com.gabe.monop.application.modules.search.searchByUF.SearchByUFFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_fragment -> {
                toolbar.title = "MonOp"

                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.search_fragment -> {
                toolbar.title = "Buscar obras"
                val fragment = SearchByUFFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.contact_fragment -> {
                toolbar.title = "Contato"
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

        Dexter.withActivity(this)
            .withPermission(Manifest.permission.INTERNET)
            .withListener(object: PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    print("Success")
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?) {
                    print("Rational something")
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    print("Denied")
                }
            })
            .check()
    }
}
