package com.example.androidcode.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.androidcode.R
import com.example.androidcode.home.domain.data.ListRow
import kotlinx.android.synthetic.main.item_listdata_row.view.*

class DataListAdapter constructor(cxt: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listData: MutableList<ListRow> = mutableListOf()
    var context = cxt

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listdata_row, parent, false)
        return ListDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListDataViewHolder).initViews(context, listData.get(position))
    }

    class ListDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val view: View = itemView
        private val txtTitle: TextView = view.tvTitle
        private val txtDescription: TextView = view.tvDescription
        private val imgImage: ImageView = view.ivImage


        fun initViews(context: Context, data: ListRow) {
            txtTitle.visibility = View.GONE
            txtDescription.visibility = View.GONE
            imgImage.visibility = View.GONE

            data.title?.let {
                txtTitle.visibility = View.VISIBLE
                txtTitle.text = data.title
            }

            data.description?.let {
                txtDescription.visibility = View.VISIBLE
                txtDescription.text = data.description
            }

            imgImage.setImageBitmap(null)

            data.imageHref?.let {
                imgImage.visibility = View.VISIBLE
                var imageUrl = data.imageHref

                if (data.imageHref.startsWith("http")) {
                    imageUrl = data.imageHref.replace("http", "https")
                }

                Glide.with(context)
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgImage)
            }
        }
    }
}
