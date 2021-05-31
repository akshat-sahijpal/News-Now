package com.akshatsahijpal.newsnow.adapter.vp

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akshatsahijpal.newsnow.ui.fragment.HomeFragment
import com.akshatsahijpal.newsnow.ui.fragment.SaveNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.SearchFragment

class BottomNavAdapter(manager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = when (position) {
        0 -> HomeFragment()
        1 -> SearchFragment()
        else -> SaveNewsFragment()
    }
}