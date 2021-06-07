package com.akshatsahijpal.newsnow.adapter.vp

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akshatsahijpal.newsnow.ui.fragment.headlines.HomeFragment
import com.akshatsahijpal.newsnow.ui.fragment.notifications.NotificationFragment
import com.akshatsahijpal.newsnow.ui.fragment.favourites.SaveNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.search.SearchFragment

class BottomNavAdapter(manager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int) = when (position) {
        0 -> HomeFragment()
        1 -> SearchFragment()
        2 -> SaveNewsFragment()
        else -> NotificationFragment()
    }
}