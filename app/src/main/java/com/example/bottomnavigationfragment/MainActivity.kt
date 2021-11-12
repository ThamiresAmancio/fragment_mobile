package com.example.bottomnavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var  btnHome : Button
    lateinit var  btnCliente : Button
    lateinit var  btnBusca : Button

    lateinit var  homeFragment : Fragment
    lateinit var  buscaFragment : Fragment
    lateinit var  clientFragment : Fragment

    lateinit var toolbar : Toolbar

    lateinit var navigation : NavigationBarView

    lateinit var bottomNavigation : BottomNavigationView
    lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBusca = findViewById(R.id.btn_busca)
        btnCliente = findViewById(R.id.btn_clientes)
        btnHome = findViewById(R.id.btn_home)

        toolbar = findViewById(R.id.toolbar)

//       setSupportActionBar(toolbar)

        navigation = findViewById(R.id.navigation)

        drawer = findViewById(R.id.drawer)

        toolbar.setTitle("TESTE DRAWER")

        buscaFragment = BuscarFragment()
        homeFragment = HomeFragment()
        clientFragment = ClientFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation)

        btnHome.setOnClickListener {
            setFragment(homeFragment)
        }
        btnCliente.setOnClickListener {
            setFragment(clientFragment)
        }
        btnBusca.setOnClickListener {
            setFragment(buscaFragment)
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            onNavigationItemSelected(item)
            true
        }

//        navigation.setNavigationItemSelectedListner{this}
    }



    private fun setFragment (fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()

    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home ->{
                setFragment(homeFragment)
            }
            R.id.menu_busca->{
                setFragment(buscaFragment)
            }
           else -> {
                setFragment(clientFragment)
            }
        }
        return true
    }
}