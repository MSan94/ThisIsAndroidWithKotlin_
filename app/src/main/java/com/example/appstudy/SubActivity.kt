package com.example.appstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")

        binding.textViewName.text = name
        binding.textViewAge.text = age

        binding.btnFinish.setOnClickListener {
            val returnVal = Intent()
            returnVal.putExtra("returnValue", "안녕~~~")
            setResult(RESULT_OK,returnVal)
            finish()
        }
    }
}