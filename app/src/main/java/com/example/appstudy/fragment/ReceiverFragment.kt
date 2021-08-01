package com.example.appstudy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.appstudy.R
import com.example.appstudy.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {
    lateinit var binding: FragmentReceiverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // request는 요청 전체에 대한 키
        // 실제값은 bundle안에 Map형태로 담겨있다.
        // bundle.getString에 입력되는 valueKey는 요청에 담겨 있는 여러 개의 값 중 하나의 값을 가리키는 키
        // 스코프함수 let을 통해 값이 있을 경우만 꺼내도록 설정
        setFragmentResultListener("request"){ key , bundle ->
            bundle.getString("valueKey")?.let{
                binding.textView.text = it
            }
        }
    }
}