package com.example.viewpager.Fragments.pagerFragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.Fragments.blankFragment.BlankFragment

private const val NUM_PAGES = 3

class PagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        val isLast = position+1 == NUM_PAGES
        return BlankFragment.newInstance(position+1,isLast)

    }
}