package com.example.appstudy.base

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

abstract class BaseActivity : AppCompatActivity(){
    abstract fun permissionGranted(requestCode : Int)
    abstract fun permissionDenied(requestCode : Int)

    fun requirePermissions(permissions : Array<String>, requestCode : Int){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            permissionGranted(requestCode)
        //권한 요청
        }else{
            // 권한체크를 해야되는 버전이면 else 에서 모두 승인된 것을 확인, 파라미터로 전달받은 permissions에는 권한 배열이 있
            // all 메서드로 배열 속에 모든 값을 체크가능
            val isAllPermissionsGranted = permissions.all{
                checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
            }
            if(isAllPermissionsGranted){
                permissionGranted(requestCode)
            }else{
                ActivityCompat.requestPermissions(this, permissions, requestCode)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.all { it == PackageManager.PERMISSION_GRANTED }){
            permissionGranted(requestCode)
        }else{
            permissionDenied(requestCode)
        }
    }
}