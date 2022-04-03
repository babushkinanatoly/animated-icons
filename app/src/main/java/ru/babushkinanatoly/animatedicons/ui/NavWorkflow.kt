package ru.babushkinanatoly.animatedicons.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.google.android.material.transition.MaterialFadeThrough
import ru.babushkinanatoly.animatedicons.R
import ru.babushkinanatoly.animatedicons.databinding.WorkflowNavBinding

class NavWorkflow : Fragment(R.layout.workflow_nav) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            childFragmentManager.commitNow {
                add(R.id.navContainer, FirstFragment())
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        WorkflowNavBinding.bind(requireView()).apply {
            navBottomBar.setOnItemSelectedListener { item ->
                if (navBottomBar.selectedItemId != item.itemId) {
                    childFragmentManager.findFragmentById(R.id.navContainer)?.apply {
                        exitTransition = MaterialFadeThrough()
                    }
                    val newFragment = when (item.itemId) {
                        R.id.menu_nav_1 -> FirstFragment()
                        R.id.menu_nav_2 -> SecondFragment()
                        else -> error("Unknown item: ${item.title}")
                    }
                    newFragment.enterTransition = MaterialFadeThrough()
                    childFragmentManager.apply {
                        commit {
                            replace(R.id.navContainer, newFragment)
                        }
                    }
                }
                true
            }
        }
    }
}
