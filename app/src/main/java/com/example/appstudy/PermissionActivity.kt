package com.example.appstudy

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.appstudy.databinding.ActivityPermissionBinding

// 1. 권한에 대한 사용자 승읜 확인 ( 이전에 승인 했는지 )
// 2. 사용자에게 승인 요청
// 3. 사용자 승인 후 처리
// 사용자에게 승인 요청 : ActivityCompat.RequestPermission()을 로출하면 사용자에게 권한 요청 팝업 생성
//                  : onRequestPermissionResult() 메서드로 반환
class PermissionActivity : AppCompatActivity() {
    val binding by lazy { ActivityPermissionBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCamera.setOnClickListener {
            // 권한에 대한 사용자 승인 확인
            checkPermission()
        }
    }

    fun checkPermission(){
        // 카메라 권한의 승인 상태 확인
        val cameraPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
        // cameraPermission에 저장된 값이 승인 되었는지 아닌지 따라 분기 처리
        if( cameraPermission == PackageManager.PERMISSION_GRANTED){
            startProcess()
        }else{
            requestPermission()
        }
    }

    fun startProcess(){
        Toast.makeText(this, "카메라를 실행",Toast.LENGTH_SHORT).show()

    }
    fun requestPermission(){
        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),99)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,// 요청한 주체를 확인하는 코드, requestPermission() 메서드의 세번째 파라미터로 전달
        permissions: Array<out String>, // 요청한 권한 목록, requestPermission() 메서드의 두 번쨰 파라미터로 전달
        grantResults: IntArray // 권한 목록에 대한 승인/미승인 값, 권한 목록의 개수와 같은 수의 결과값 전달
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
           99 -> {
               if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                   startProcess()
               }else{
                   finish()
               }
           }
       }
    }
}