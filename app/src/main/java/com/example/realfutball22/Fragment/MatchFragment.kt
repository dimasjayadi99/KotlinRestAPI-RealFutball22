package com.example.realfutball22.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.realfutball22.Adapter.TablayoutAdapter
import com.example.realfutball22.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MatchFragment : Fragment() {
    private lateinit var tabAdapter: TablayoutAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(container?.context).inflate(R.layout.fragment_match, container, false)

        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager)
        val tablayout = view.findViewById<TabLayout>(R.id.tabLayout)

        tabAdapter = TablayoutAdapter(childFragmentManager,lifecycle)
        viewpager.adapter = tabAdapter

        TabLayoutMediator(tablayout,viewpager) { tab, position ->
            when(position){
                0 -> tab.text = "Scheduled"
                1 -> tab.text = "Finished"
            }
        }.attach()

        return view
    }

}