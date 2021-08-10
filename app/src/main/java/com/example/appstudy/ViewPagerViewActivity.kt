package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityViewpagerviewBinding
import com.example.appstudy.viewpager.CustomPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerViewActivity : AppCompatActivity() {

    val binding by lazy { ActivityViewpagerviewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textList = listOf("뷰A", "뷰B", "뷰C", "뷰D")
        val customAdapter  = CustomPagerAdapter()
        customAdapter.textList = textList
        binding.viewPager.adapter = customAdapter
        val tabTitles = listOf("View A", "View B" , "View C" , "View D")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}