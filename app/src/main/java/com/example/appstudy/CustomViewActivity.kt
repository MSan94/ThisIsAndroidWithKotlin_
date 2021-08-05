package com.example.appstudy

import android.content.Context
import android.graphics.*
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
        val customView = CustomView("안녕코틀린",this)
        binding.fragmeLayout.addView(customView)
    }

}


class CustomView(text : String, context : Context) : View(context){ //text를 추가하여 입력한 스트링을 출력
    val text : String
    init{
        this.text = text
    }
    // Canvas : 그리기 도구
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        //drawText 기준은 문자열의 좌측 하단
//        paint.color = Color.BLACK // 대상의 색상, 글자나 도형의 색상 정의
//        paint.textSize = 100f // float형, 글자의 크기, drawText()경우만 사용
//        canvas?.drawText(text,0f,100f,paint) //글자, x좌표, y좌표, 색상정보
//    }
    // View에 그림 그리기
    // color : 대상의 색상, 도형의 색상
    // style : 도형의 형태, 외곽선을 그리거나 면을 채우는 등의 모양 정의
    // strokeWidth : 외곽선을 그릴 경우 외곽선의 두께 정의

    // 원 그리기
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.style = Paint.Style.FILL
//        paint.color = Color.BLUE
//        canvas?.drawCircle(150f,300f,100f, paint)
//    }
    // 외곽선 그리기
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.style = Paint.Style.STROKE
//        paint.color = Color.BLUE
//        paint.strokeWidth = 10f
//        canvas?.drawCircle(150f,300f,100f, paint)
//    }
    // 사각형 그리기
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.style = Paint.Style.STROKE
//        paint.color = Color.BLUE
//        paint.strokeWidth = 20f
//        // Rect 클래스에 사각형의 left,top,right,bottom좌표를 생성
//        val rect = Rect(50,450,250,650)
//        canvas?.drawRect(rect,paint)
//    }

    //라운드 사각형 그리기
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.CYAN
        // Rect 클래스에 사각형의 left,top,right,bottom좌표를 생성
        val rect = RectF(50f,450f,250f,650f)
        canvas?.drawRoundRect(rect,50f,50f,paint)
    }

    // 이렇게 View 클래스를 상속받은 후 onDraw() 메서드로 전달되는 canvas를 사용하면
    // 원하는 그림을 그릴 수 있다.
}