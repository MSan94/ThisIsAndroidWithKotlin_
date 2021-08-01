package com.example.appstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.appstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, SubActivity::class.java);
        intent.putExtra("name", "안명성")
        intent.putExtra("age", "26")
        binding.btnMove.setOnClickListener{
            startActivityForResult(intent,1000)
        }

        /** 스피너 **/
        var data = listOf("- 선택하세요 -", "1월","2월","3월","4월","5월","6월")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.result.text = data[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        /**리사이클러뷰**/
        binding.btnRecyclerView.setOnClickListener{
            val intent = Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        /**프래그먼트**/
        binding.btnFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
        /**프래그먼트 리시브**/
        binding.btnFragmentRecv.setOnClickListener {
            val intent = Intent(this,FragmentReceiverActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TestValue", " 호출 ${requestCode} , ${resultCode}")
        if(requestCode == 1000 && resultCode == RESULT_OK){
            Log.d("TestValue", "성공")
            binding.textViewVal.text = data?.getStringExtra("returnValue")
        }else{
            Log.d("TestValue", "실패")
        }
    }
}