package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstudy.databinding.ActivityFragmentBinding
import com.example.appstudy.fragment.DetailFragment
import com.example.appstudy.fragment.ListFragment
import java.lang.Exception

// 프래그먼트는 서로 다른 크기의 화면을 가진 기기에서 하나의 액티비티로 서로 다른 레이아웃을 구성
// 프래그먼트를 삽입하는 과정은 하나의 트랜잭션으로 관리
// begin transaction > add fragment > commit transaction

class FragmentActivity : AppCompatActivity() {
    val binding by lazy { ActivityFragmentBinding.inflate(layoutInflater) }

    lateinit var listFragment:ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
        
        // 생성된 프래그먼트에 값 전달
        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }

    fun setFragment(){
        // 프래그먼트 생성 시 값 전달
        // arguments를 통해 전달하는데 이것은 프래그먼트 기본 프로퍼티로 선언 없이 사용 가능
        // arguments에 전달하면 생성된 프래그먼트에서 arguments로 꺼낼 수 있다.
        var bundle = Bundle()
        bundle.putString("key1","List Fragment")
        bundle.putInt("key2", 20200801)
        listFragment = ListFragment()
        listFragment.arguments = bundle
        // add(레이아웃, 프래그먼트) : 프래그먼트를 레이아웃에 추가
        // replace(레이아웃 , 프래그먼트) : 레이아웃에 삽입되어 있는 프래그먼트와 교체
        // remove(프래그먼트) : 지정한 프래그먼트 삭제
        // FrameLayout을 사용할 경우 프랜잭션 필요하지만, Fragment를 사용하면 불필요
        supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout, listFragment)
                .commit()
    }

    // 프래그먼트 전환
    fun goDetail(){
        val detailFragment = DetailFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout,detailFragment)
            .addToBackStack("detail")
            .commit()
        // addToBackStack으로 프래그먼트 트랜잭션을 백스택에 담을 수 있다.
        // 뒤로가기 버튼으로 트랜잭션 전체를 마치 액티비티처럼 제거가능
    }
    fun goBack(){
        onBackPressed()
    }
}

