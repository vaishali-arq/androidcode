package com.example.androidcode.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcode.R
import com.example.androidcode.home.adapter.DataListAdapter
import com.example.androidcode.home.domain.data.ListRow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainViewModel = MainViewModel()
    lateinit var adapter: DataListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
        initUI()
        callWebservice()
    }

    private fun initUI() {
        srlPulltoRefresh.setOnRefreshListener {
            callWebservice()
            srlPulltoRefresh.isRefreshing = false
        }

        rvDataList.layoutManager = LinearLayoutManager(this)
        adapter = DataListAdapter(this)
        rvDataList.adapter = adapter
    }

    private fun callWebservice() {
        mainViewModel.callWebservice()
    }

    private fun observeViewModel() {
        mainViewModel.listResult.observe(this, Observer {
            if (it.success != null) {
                supportActionBar?.title = it.success.title
                updateListData(it.success.listRow)
            }
        })
    }

    private fun updateListData(data: List<ListRow>) {
        var listDataItems: MutableList<ListRow> = data.toMutableList()

        adapter.apply {
            listData = listDataItems
        }.notifyDataSetChanged()
    }
}
