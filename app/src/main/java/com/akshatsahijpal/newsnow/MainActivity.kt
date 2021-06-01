package com.akshatsahijpal.newsnow

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.akshatsahijpal.newsnow.adapter.vp.BottomNavAdapter
import com.akshatsahijpal.newsnow.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        defaultSettings()
        var pager = _binding.viewpager2
        var menu = _binding.menu
        pager.adapter = BottomNavAdapter(supportFragmentManager, lifecycle)
        menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeIconBtn -> pager?.currentItem = 0// item 2
                R.id.searchIconBtn -> pager?.currentItem = 1
                R.id.saveIconBtn -> pager?.currentItem = 2
                else -> pager?.currentItem = 3
            }
            return@setOnNavigationItemSelectedListener true
        }
        pager.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return true
            }
        })
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> menu.menu.findItem(R.id.homeIconBtn)?.isChecked = true
                    1 -> menu.menu.findItem(R.id.searchIconBtn)?.isChecked = true
                    2 -> menu.menu.findItem(R.id.saveIconBtn)?.isChecked = true
                    3 -> menu.menu.findItem(R.id.NotificationBtn)?.isChecked = true
                }
            }
        })
    }

    private fun defaultSettings() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}