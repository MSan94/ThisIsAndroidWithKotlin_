package com.example.appstudy.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appstudy.FragmentActivity
import com.example.appstudy.R
import com.example.appstudy.databinding.FragmentListBinding

class ListFragment : Fragment() {


    var fragmentActivity : FragmentActivity? = null //액티비티를 담아둘 변수 선언
    lateinit var binding:FragmentListBinding

    // 액티비티가 프래그먼트를 요청하면 onCreateView()를 통해 뷰를 만들어서 보여줌
    // inflater : 레이아웃 파일을 로드하기 위한 레이아웃 인플레이터를 기본으로 제공
    // container : 프래그먼트 레이아웃이 배치되는 부모 레이아웃 ( 액티비티의 레이아웃)
    // savedInstanceState : 상태 값 저장을 위한 보조 도구, 액티비티의 onCreate의 파라미터와 동일하게 동작
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.inflate(inflater,container,false)
        binding.btnNext.setOnClickListener { fragmentActivity?.goDetail() }

        // 액티비티에서 넘겨준 값 받기
        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"

        return binding.root //onCreateView()의 반환값이 View이므로 root를 넘겨줌
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // onAttach()를 통해 넘어온 Context를 캐스팅하여 액티비티를 담는다. (부모의 전체가 담겨있다.)
        // context의 타입이 액티비티를 확인하고 fragmentActivity 프로퍼티에 저장
        if(context is FragmentActivity) fragmentActivity = context
    }
    
    // 생성되어 있는 프래그먼트에 값 전달
    fun setValue(value:String){
        binding.textFromActivity.text = value
    }
}