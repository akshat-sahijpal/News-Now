package com.akshatsahijpal.newsnow.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.akshatsahijpal.newsnow.adapter.vp.TabAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var act = activity as AppCompatActivity
        act.setSupportActionBar(_binding.appBarLayout9)
        var pager = _binding.viewPager4074
        pager.adapter = TabAdapter(requireActivity().supportFragmentManager, lifecycle)
        TabLayoutMediator(_binding.tabLayout4054, _binding.viewPager4074) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Latest"
                    tab.id = 0
                }
                1 -> {
                    tab.text = "India"
                    tab.id = 1
                }
                2 -> {
                    tab.text = "World"
                    tab.id = 2
                }
                3 -> {
                    tab.text = "Business"
                    tab.id = 3
                }
                4 -> {
                    tab.text = "Technology"
                    tab.id = 4
                }
                5 -> {
                    tab.text = "Entertainment"
                    tab.id = 5
                }
                6 -> {
                    tab.text = "Sports"
                    tab.id = 6
                }
                7 -> {
                    tab.text = "Science"
                    tab.id = 7
                }
                8 -> {
                    tab.text = "Health"
                    tab.id = 8
                }
            }
        }.attach()
        _binding.tabLayout4054.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    pager.setCurrentItem(tab.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                _binding.tabLayout4054.selectTab(_binding.tabLayout4054.getTabAt(position))
            }
        })
    }
}