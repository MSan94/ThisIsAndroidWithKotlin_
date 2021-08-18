package com.example.appstudy

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.URL

suspend fun loadImage(imageUrl : String) : Bitmap{
    val url = URL(imageUrl)
    val stream = url.openStream()
    return BitmapFactory.decodeStream(stream)
}

class CoroutineActivity : AppCompatActivity() {
    val binding by lazy { ActivityCoroutineBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDownload.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                // 버튼을 클릭하면 로딩바가 보이며 url 파싱
                binding.progress.visibility = View.VISIBLE
                val url = binding.editUrl.text.toString()
                // loadImage() 함수를 호출하면서 url을 전달, 이 부분은 백그라운드 처리를 담당하는 IO 컨텍스트에서 진행되야 하므로 withContext() 사용
                // 결과값은 bitmap에 저장
                val bitmap = withContext(Dispatchers.IO){
                    loadImage(url)
                }
                binding.imagePreview.setImageBitmap(bitmap)
                binding.progress.visibility = View.GONE
            }
        }

//        binding.buttonDownload.setOnClickListener {
//            CoroutineScope(Dispatchers.Main).launch {
//                // 버튼을 클릭하면 로딩바가 보이며 url 파싱
//                binding.progress.visibility = View.VISIBLE
//                val url = binding.editUrl.text.toString()
//                // loadImage() 함수를 호출하면서 url을 전달, 이 부분은 백그라운드 처리를 담당하는 IO 컨텍스트에서 진행되야 하므로 withContext() 사용
//                // 결과값은 bitmap에 저장
//                val bitmap = withContext(Dispatchers.IO){
//                    loadImage(url)
//                }
//                binding.imagePreview.setImageBitmap(bitmap)
//                binding.progress.visibility = View.GONE
//            }
//        }

        binding.run {
            buttonDownload.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        try{
                            // 버튼을 클릭하면 로딩바가 보이며 url 파싱
                            binding.progress.visibility = View.VISIBLE
                            val url = binding.editUrl.text.toString()
                            // loadImage() 함수를 호출하면서 url을 전달, 이 부분은 백그라운드 처리를 담당하는 IO 컨텍스트에서 진행되야 하므로 withContext() 사용
                            // 결과값은 bitmap에 저장
                            val bitmap = withContext(Dispatchers.IO) {
                                loadImage(url)
                            }
                            binding.imagePreview.setImageBitmap(bitmap)
                            binding.progress.visibility = View.GONE
                        }catch (e : Exception){
                            cancel()
                        }
                    }

            }
        }

    }

}