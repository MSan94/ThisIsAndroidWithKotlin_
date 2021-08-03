package com.example.appstudy

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityCustomviewBinding

class CustomViewActivity : AppCompatActivity() {
    val binding by lazy { ActivityCustomviewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 커스텀뷰 생성 후 삽입
        val customView = CustomView(this)
        binding.fragmeLayout.addView(customView)
    }

}


class CustomView(context : Context) : View(context){
    // Canvas : 그리기 도구
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        //drawText기준은 문자열의 좌측 하단
        paint.color = Color.BLACK // 대상의 색상, 글자나 도형의 색상 정의
        paint.textSize = 100f // float형, 글자의 크기, drawText()경우만 사용
        canvas?.drawText("안녕하세요",0f,100f,paint) //글자, x좌표, y좌표, 색상정보
    }
}