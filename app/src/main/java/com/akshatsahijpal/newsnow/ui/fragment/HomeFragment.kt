package com.akshatsahijpal.newsnow.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.akshatsahijpal.newsnow.adapter.vp.TabAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentHomeBinding
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

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        if (_binding.tabLayout4054.id == 0) {
                            _binding.tabLayout4054[0].alpha = 1.0f
                        }
                    }
                    1 -> {
                        if (_binding.tabLayout4054.id == 1) {
                            _binding.tabLayout4054[1].alpha = 1.0f
                        }
                    }
                    2 -> {
                        if (_binding.tabLayout4054.id == 2) {
                            _binding.tabLayout4054[2].alpha = 1.0f
                        }
                    }
                    3 -> {
                        if (_binding.tabLayout4054.id == 3) {
                            _binding.tabLayout4054[3].alpha = 1.0f
                        }
                    }
                    4 -> {
                        if (_binding.tabLayout4054.id == 4) {
                            _binding.tabLayout4054[4].alpha = 1.0f
                        }
                    }
                    5 -> {
                        if (_binding.tabLayout4054.id == 5) {
                            _binding.tabLayout4054[5].alpha = 1.0f
                        }
                    }
                    6 -> {
                        if (_binding.tabLayout4054.id == 6) {
                            _binding.tabLayout4054[6].alpha = 1.0f
                        }
                    }
                    7 -> {
                        if (_binding.tabLayout4054.id == 7) {
                            _binding.tabLayout4054[7].alpha = 1.0f
                        }
                    }
                    8 -> {
                        if (_binding.tabLayout4054.id == 8) {
                            _binding.tabLayout4054[8].alpha = 1.0f
                        }
                    }
                }
            }
        })
        _binding.appBarLayout9.setNavigationOnClickListener {

        }
        setHasOptionsMenu(true)
    }
}