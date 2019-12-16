package com.vtools.quicknews.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vtools.quicknews.R
import com.vtools.quicknews.adapter.PageAdapter
import com.vtools.quicknews.animation.FadeIn
import com.vtools.quicknews.animation.FadeOut
import com.vtools.quicknews.animation.HideToUp
import com.vtools.quicknews.animation.ShowFromUpToDown
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewPager = main_view_pager
        mBottomNavigationLayout = bottom_navigation
        setupViewPager(mViewPager)
        pagerChangeListener()
        bottomNavigationChangeLister()
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment.newInstance(), "Home")
        adapter.addFragment(MenuFragment.newInstance(), "Menu")
        adapter.addFragment(ProfileFragment.newInstance(), "Profile")
        viewPager.adapter = adapter
    }

    private fun bottomNavigationChangeLister(){
        mBottomNavigationLayout.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_menu_home -> {
                    mViewPager.currentItem = 0
                    controlSeachbarView(0)
                    true
                }
                R.id.item_menu_menu -> {
                    mViewPager.currentItem = 1
                    controlSeachbarView(1)
                    true
                }
                R.id.item_menu_profile -> {
                    mViewPager.currentItem = 2
                    controlSeachbarView(2)
                    true
                }
            }
            true
        }
    }

    private fun pagerChangeListener(){
        mViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                when (position){
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
    private fun controlSeachbarView(position:Int){
        when(position){
            0 -> {
                seach_bar.ShowFromUpToDown()
            }
            1 -> {
                seach_bar.HideToUp()
            }
            2 -> {
                seach_bar.HideToUp()
            }
        }
    }


}
