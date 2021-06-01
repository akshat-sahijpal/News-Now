package com.akshatsahijpal.newsnow.adapter.vp

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akshatsahijpal.newsnow.ui.fragment.subFragment.*

class TabAdapter constructor(
    manager: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount(): Int {
        return 9
    }

    override fun createFragment(position: Int) = when (position) {
        0 -> LatestFragment()
        1 -> CountrySpecificNewsFragment()
        2 -> WorldNewsFragment()
        3 -> BusinessNewsFragment()
        4 -> TechnologyNewsFragment()
        5 -> EntertainmentFragment()
        6 -> SportsNewsFragment()
        7 -> ScienceNewsFragment()
        else -> HealthFragment()
    }
}