package com.example.viewpager.Fragments.pagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.R
import com.example.viewpager.databinding.FragmentPagerBinding

class PagerFragment : Fragment() {

lateinit var binding: FragmentPagerBinding
lateinit var adapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater,container,false)
        adapter = PagerAdapter(this)
        viewPager = binding.viewPager

        viewPager.adapter = adapter

        return binding.root
    }

    companion object{
        lateinit var viewPager: ViewPager2
    }

}