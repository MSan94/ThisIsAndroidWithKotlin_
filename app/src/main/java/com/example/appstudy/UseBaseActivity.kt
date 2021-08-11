package com.example.appstudy

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.base.BaseActivity
import com.example.appstudy.databinding.ActivityUsebaseBinding

class UseBaseActivity : BaseActivity(){
    val binding by lazy { ActivityUsebaseBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCamera.setOnClickListener {
            requirePermissions(arrayOf(Manifest.permission.CAMERA), 10)
        }
    }

    // 카메라 on
    override fun permissionGranted(requestCode: Int) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 99)
    }

    override fun permissionDenied(requestCode: Int) {
        Toast.makeText(this, "카메라 거부", Toast.LENGTH_SHORT).show()
    }
    
    // 카메라 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 10){
            Toast.makeText(this, "카메라 On", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "카메라 Fail", Toast.LENGTH_SHORT).show()
        }
    }
}