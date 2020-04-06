package com.example.androidcode.home.presentation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcode.R
import com.example.androidcode.home.adapter.DataListAdapter
import com.example.androidcode.home.domain.data.ListRow
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity is activity class to call webservice and update UI
 */
class MainActivity : AppCompatActivity() {

    val mainViewModel = MainViewModel(this)
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
        mainViewModel.progressState.observe(this, Observer { inProgress ->
            if (inProgress) {
                pbLoading.visibility = VISIBLE
            } else {
                pbLoading.visibility = GONE
            }
        })

        mainViewModel.listResult.observe(this@MainActivity, Observer {
            val loginResult = it ?: return@Observer

            if (loginResult.errorMsg != null) {
                var errorMessage =
                    loginResult.errorMsg ?: getString(R.string.error_something_went_wrong)
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }

            if (loginResult.success != null) {
                supportActionBar?.title = loginResult.success.title
                updateListData(loginResult.success.listRow)
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
