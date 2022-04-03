package ru.babushkinanatoly.animatedicons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import ru.babushkinanatoly.animatedicons.ui.NavWorkflow

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                val navFragment = NavWorkflow()
                add(R.id.mainContainer, navFragment)
                setPrimaryNavigationFragment(navFragment)
            }
        }
    }
}
