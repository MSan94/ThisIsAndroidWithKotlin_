package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityRecyclerviewBinding
import com.example.appstudy.databinding.ActivityViewpagerBinding
import com.example.appstudy.viewpager.*
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    val binding by lazy { ActivityViewpagerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 프래그먼트 리스트 생성
        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter
        val tabTitles = listOf<String>("A","B","C","D") // 메뉴명을 미리 정의
        // 탭영역 , 뷰페이저 영역
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}