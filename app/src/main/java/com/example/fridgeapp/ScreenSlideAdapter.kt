package com.example.fridgeapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlideAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3 // 페이지 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainImageFragment()
            1 -> MarketPriceFragment()
            2 -> PageFragment.newInstance("레시피 추천")
            else -> PageFragment.newInstance("기타 페이지")
        }
    }
}