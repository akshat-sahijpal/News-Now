package com.akshatsahijpal.newsnow.adapter.vp

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.business.BusinessNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.country.CountrySpecificNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.entertainment.EntertainmentFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.health.HealthFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.latest.LatestFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.science.ScienceNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.sports.SportsNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.technology.TechnologyNewsFragment
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.word.WorldNewsFragment

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