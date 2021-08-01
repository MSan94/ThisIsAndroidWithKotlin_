package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityFragmentreceiverBinding
import com.example.appstudy.fragment.ReceiverFragment
import com.example.appstudy.fragment.SenderFragment

class FragmentReceiverActivity : AppCompatActivity() {
    val binding by lazy { ActivityFragmentreceiverBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentSender,SenderFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentReceiver, ReceiverFragment())
            .commit()
    }

}