package com.example.appstudy.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    //  화면에 보여줄 프래그먼트 목록
    var fragmentList = listOf<Fragment>()

    // 어댑터가 화면에 보여줄 전체 프래그먼트의 개수 반환
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    // 현재 페이지의 position이 파라미터로 넘어온다.
    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}