package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appstudy.databinding.ActivityRecyclerviewBinding
import com.example.appstudy.recycler.CustomAdapter
import com.example.appstudy.recycler.Memo

/**
 * 스피너의 확장된 형태
 * 리사이클러뷰 처럼 목록을 표시하는 컨테이너들은 표시될 데이터와 아이템 레이아웃을 어댑터에서 연결하므로
 * 어댑터의 어떤 아이템 레이아웃을 사용하느냐에 따라 표시되는 모양을 다르게 만들 수 있다.
 *
 * - 어댑터
 *
 */

class RecyclerViewActivity : AppCompatActivity() {
    val binding by lazy { ActivityRecyclerviewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 사용할 데이터를 생성
        val data : MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter //어댑터 연결
        // 리사이클러뷰를 화면에 보여주는 형태를 결정하는 레이아웃 매니저 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        // 3가지 레이아웃 매니저
        // LinearLayoutManager
        // 세로 : 기본으로 세로 스크롤 : LinearLayoutManager(this)
        // 가로 : 컬럼 개수를 지정해서 개수만큼 그리드 : (this,LineayLayoutManager.HORIZONTAL, false)

        // GridLayoutManager
        // 데이터 사이즈에 따라 그리드의 크기가 결정, 두번째 파라미터에 한 줄에 몇개아이템을 표시할 지 정의
        // GridLayoutManager(this, 3)

        // StaggeredGridLayoutManager
        // 세로 스크롤 : 컨텍스트를 사용하지 않아 this 필요 x, 첫 번째 파라미터는 한줄에 표시되는 아이템 개수, 두번째는 세로방향 설정
        // StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL OR HORIZONTAL)
    }

    fun loadData() : MutableList<Memo>{
        val data : MutableList<Memo> = mutableListOf()
        for(no in 1..100){
            val title = "제목입니다. $no"
            val date = System.currentTimeMillis()
            var memo = Memo(no,title,date)
            data.add(memo)
        }
        return data
    }
}