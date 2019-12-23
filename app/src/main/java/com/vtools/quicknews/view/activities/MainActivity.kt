package com.vtools.quicknews.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vtools.quicknews.R
import com.vtools.quicknews.adapter.PageAdapter
import com.vtools.quicknews.animation.HideToLeft
import com.vtools.quicknews.animation.ShowFromLeftToRight
import com.vtools.quicknews.view.fragments.HomeFragment
import com.vtools.quicknews.view.fragments.MenuFragment
import com.vtools.quicknews.view.fragments.ProfileFragment
import com.vtools.quicknews.viewmodel.activities.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_drawer_layout.*
import kotlinx.android.synthetic.main.toolbar_search_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    lateinit var mViewPager: ViewPager
    lateinit var mBottomNavigationLayout: BottomNavigationView
    private val fragmentHome by lazy { HomeFragment.newInstance() }
    private val fragmentMenu by lazy { MenuFragment.newInstance() }
    private val fragmentProfile by lazy { ProfileFragment.newInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
        initBottomNavigation()
        setupViewPager(mViewPager)
        pagerChangeListener()
        bottomNavigationChangeLister()
        searchViewListener()
    }
    private fun initViewPager(){
        mViewPager = main_view_pager
    }
    private fun initBottomNavigation(){
        mBottomNavigationLayout = bottom_navigation
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragment(fragmentHome, "Home")
        adapter.addFragment(fragmentMenu, "Menu")
        adapter.addFragment(fragmentProfile, "Profile")
        viewPager.adapter = adapter
    }
    private fun searchViewListener(){
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                fragmentHome.searchQuery(query)
                return false
            }
        })
    }

    private fun bottomNavigationChangeLister() {
        mBottomNavigationLayout.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.item_menu_home -> {
                    if (!it.isChecked) {
                        mViewPager.currentItem = 0
                        controlSeachbarView(0)
                    }
                    true
                }
                R.id.item_menu_menu -> {
                    if (!it.isChecked) {
                        mViewPager.currentItem = 1
                        controlSeachbarView(1)
                    }
                    true
                }
                R.id.item_menu_profile -> {
                    if (!it.isChecked) {
                        mViewPager.currentItem = 2
                        controlSeachbarView(2)
                    }
                    true
                }
            }
            true
        }
    }

    private fun pagerChangeListener() {
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                when (position) {
                    0 -> {
                        mBottomNavigationLayout.selectedItemId = R.id.item_menu_home
                        controlSeachbarView(position)
                    }
                    1 -> {
                        mBottomNavigationLayout.selectedItemId = R.id.item_menu_menu
                        controlSeachbarView(position)
                    }
                    2 -> {
                        mBottomNavigationLayout.selectedItemId = R.id.item_menu_profile
                        controlSeachbarView(position)
                    }
                }
            }
        })
    }

    private fun controlSeachbarView(position: Int) {
        when (position) {
            0 -> {
                seach_bar.ShowFromLeftToRight()
            }
            else -> {
                seach_bar.HideToLeft()
            }
        }

    }
}
