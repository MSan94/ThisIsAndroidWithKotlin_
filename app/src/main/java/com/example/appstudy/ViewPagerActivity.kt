package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityRecyclerviewBinding
import com.example.appstudy.databinding.ActivityViewpagerBinding
import com.example.appstudy.viewpager.*

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
    }

}