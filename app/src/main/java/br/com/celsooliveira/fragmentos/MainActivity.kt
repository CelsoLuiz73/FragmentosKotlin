package br.com.celsooliveira.fragmentos

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(),View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener {

//    private lateinit var buttonHome: Button
//    private lateinit var buttonConsoles: Button
//    private lateinit var buttonGames: Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var gameFragment: GameFragment
    private lateinit var consoleFragment: ConsoleFragment

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        buttonHome = findViewById(R.id.btn_home)
//        buttonHome.setOnClickListener(this)
//        buttonGames = findViewById(R.id.btn_games)
//        buttonGames.setOnClickListener(this)
//        buttonConsoles = findViewById(R.id.btn_consoles)
//        buttonConsoles.setOnClickListener(this)

        homeFragment = HomeFragment()
        consoleFragment = ConsoleFragment()
        gameFragment = GameFragment()

        bottomNavigationView = findViewById(R.id.botton_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(homeFragment)

    }

    //Gerenciador de fragmentos: Tem um Método  - Support Fragments Manager -  Que vai dizer p/ MainActivity
    //(que vai Gerenciar fragmentos) - Vamos criar um objeto do tipo SupportFragmentManager
    //Método responsável por fazer a trocas dos fragmentos

    private fun setFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()
    }

    //A função onClick recebe uma View. O componente clicado foi o botão "X", editText "Y", textView "Z"
    //qualquer view que colocamos dentro de uma activity, é passível de clique.

    override fun onClick(v: View) {
//        when(v.id){
//            R.id.btn_home -> {
//                setFragment(homeFragment)
//            }
//            R.id.btn_games -> {
//                setFragment(gameFragment)
//            }
//            R.id.btn_consoles -> {
//                setFragment(consoleFragment)
//            }
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_game -> {
                setFragment(gameFragment)
            }
            R.id.menu_console -> {
                setFragment(consoleFragment)
            }
        }
        return true
    }
}