package com.example.androidcode.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcode.R
import com.example.androidcode.home.domain.data.ListRow
import kotlinx.android.synthetic.main.item_listdata_row.view.*

class DataListAdapter constructor(cxt: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listData: MutableList<ListRow> = mutableListOf()
    var context = cxt

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_listdata_row, parent, false)
        return ListDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListDataViewHolder).initViews(context, position, listData.get(position))
    }

    class ListDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val view: View = itemView
        private val txtTitle: TextView = view.tvTitle
        private val txtDescription: TextView = view.tvDescription
        private val imgImage: ImageView = view.ivImage


        fun initViews(context: Context, position: Int, data: ListRow) {
            txtTitle.text = data.title
            txtDescription.text = data.description
        }
    }
}
