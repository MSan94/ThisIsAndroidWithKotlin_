package com.example.appstudy

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityThreadBinding
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    val binding by lazy { ActivityThreadBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        timer()

    }
    fun timer(){
        var total = 0
        var started = false

        val handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                val minute = String.format("%02d", total/60)
                val second = String.format("%02d", total%60)
                binding.textTimer.text = "$minute:$second"
            }
        }

        binding.buttonStart.setOnClickListener {
            started = true
            thread(start=true){
                while(started){
                    Thread.sleep(1000)
                    if(started){
                        total++
                        // 핸들러를 호출하는 곳이 하나 뿐이라 메시지에 0을 담아 호출
                        handler?.sendEmptyMessage(0)
                    }
                }
            }
        }

        binding.buttonStop.setOnClickListener {
            if(started){
                started = false
                total = 0
                binding.textTimer.text = "00:00"
            }
        }

    }
}