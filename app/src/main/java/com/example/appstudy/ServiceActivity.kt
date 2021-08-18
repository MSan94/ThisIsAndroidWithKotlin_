package com.example.appstudy

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityServiceBinding
import com.example.appstudy.service.MyService

class ServiceActivity : AppCompatActivity() {
    val binding by lazy { ActivityServiceBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    // 새로운 메서드를 만들 때 파라미터로 (view : View)를 사용하면 클릭 리스너 연결 없이 레이아웃
    // 파일에서 메서드 직접 접근 가능
    fun serviceStart(view : View){
        val intent = Intent(this, MyService::class.java)
        intent.action = MyService.ACTION_START
        startService(intent)
    }
    fun serviceStop(view : View){
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }

    // 서비스와 연결할 수 있는 서비스 커넥션
    // 만든 커넥션을 bindService()를 통해 시스템에 전달하면 서비스와 연결할 수 있다.
    var myService:MyService? = null
    var isService = false
    val connection = object : ServiceConnection{
        // 서비스가 연결되면 호출
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyService.MyBinder
            myService = binder.getService()
            isService = true
            Log.d("BoundService", "연결되었습니다.")
        }
        // 서비스가 정삭적으로 연결 해제 되었을땐 호출되지 않음 (비정상 종료)
        override fun onServiceDisconnected(name: ComponentName?) {
            isService = false
        }

    }

    // bindService로 서비스를 호출하며 앞에 생성한 커넥션 넘겨줌
    // 세번째 옵션인 Context.BIND_AUTO_CREATE를 설정하면 서비스가 생성되어 있지 않으면 생성 후 바인딩
    fun serviceBind(view : View){
        val intent = Intent(this, MyService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }
    
    // 연결 해제
    fun serviceUnbind(view : View){
        if(isService){
            unbindService(connection)
            isService = false
        }
    }

    fun callServiceFunction(view : View){
        if(isService){
            val message = myService?.serviceMessage()
            Toast.makeText(this, "message=${message}", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "서비스가 연결되어 있지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroy() {
        Log.d("Service", "서비스가 종료됨")
        super.onDestroy()
    }

}