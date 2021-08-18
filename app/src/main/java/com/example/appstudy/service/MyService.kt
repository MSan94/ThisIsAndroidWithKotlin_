package com.example.appstudy.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.util.Log

class MyService : Service() {

    inner class MyBinder : Binder(){
        // 액티비티와 서비스가 연결되면 바인더의 getService()를 통해 서비스에 접근 가능
        fun getService() : MyService {
            return this@MyService
        }

    }
    val binder = MyBinder()

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("StartedService", "action = $action")
        return super.onStartCommand(intent, flags, startId)
    }

    // 서비스의 메서드 호출
    fun serviceMessage() : String{
        return "Hello Activity! I am Service!"
    }

    override fun onDestroy() {
        Log.d("Service", "서비스가 종료되었습니다.")
        super.onDestroy()
    }

    companion object {
        val ACTION_START = "com.example.appstudy.START"
        val ACTION_RUN = "com.example.appstudy.RUN"
        val ACTION_STOP = "com.example.appstudy.STOP"
    }
}