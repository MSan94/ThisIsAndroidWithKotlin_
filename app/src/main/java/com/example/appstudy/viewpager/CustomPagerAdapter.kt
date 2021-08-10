package com.example.appstudy.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstudy.databinding.ItemViewpagerBinding


// RecyclerView.Adapter 상속 받고 제네릭으로 Holder 클래스 지정
class CustomPagerAdapter : RecyclerView.Adapter<Holder>(){
    var textList = listOf<String>()
    
    // 바인딩을 생성한 후 Holder에 전달
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val text = textList[position]
        holder.setText(text)
    }

    override fun getItemCount(): Int {
        return textList.size
    }
}

// Holder 클래스의 binding 파라미터로 onCreateViewHolder에서 생성할 바인딩이 전달
class Holder(val binding: ItemViewpagerBinding) : RecyclerView.ViewHolder(binding.root){
    fun setText(text : String){
        binding.textView.text = text
    }
}