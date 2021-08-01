package com.example.appstudy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.appstudy.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {
    lateinit var binding : FragmentSenderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSenderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // btnYes에 클릭 리스너를 달아 리스너 안에 valueKey를 키로, Yes를 값으로 갖는
        // 번들을 생성 후 bundle 변수에 저장,
        // setFragmentResultListener메서드를 request와 번들을 입력하여 호출하면 수신측에 전달
        binding.btnYes.setOnClickListener {
            val bundle = bundleOf("valueKey" to "Yes")
            setFragmentResult("request", bundle)
        }
        binding.btnNo.setOnClickListener {
            val bundle = bundleOf("valueKey" to "No")
            setFragmentResult("request", bundle)
        }
    }
}