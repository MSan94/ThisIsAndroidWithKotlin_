package com.example.appstudy.custom

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.appstudy.R

class CustomText : AppCompatTextView {

    //위젯 클래스를 소스 코드에서 사용할 때
    constructor(context: Context) : super(context)
    //레이아웃 파일에서 사용
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomText) // attrs.xml에 정의된 어트리뷰트 get
        val size = typed.indexCount
        for(i in 0 until size){
            when(typed.getIndex(i)){
                R.styleable.CustomText_delimeter -> {
                    val delimeter = typed.getString(typed.getIndex(i)) ?: "-" // 엘비스연산자 null이면 -
                    process(delimeter) //꺼낸값은 처리
                }
            }
        }
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun process(delimeter : String){
        var one = text.substring(0,4)
        var two = text.substring(4,6)
        var three = text.substring(6)
        setText("$one $delimeter $two $delimeter $three")
    }
}