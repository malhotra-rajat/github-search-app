package com.example.app.feature.search.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.common.AppUtils
import com.example.app.feature.search.datamodel.Item

class SearchAdapter(private var mItems: ArrayList<Item>) : RecyclerView.Adapter<RowViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)

        return RowViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.tv_repo)
        textView.text = mItems[position].name

        holder.itemView.setOnClickListener {
            mItems[position].htmlURL?.let { htmlUrl ->
                AppUtils.launchChromeCustomTabs(it.context as Activity, htmlUrl)
            }
        }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateData(items: ArrayList<Item>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    fun clearData() {
        mItems.clear()
        notifyDataSetChanged()
    }
}

class RowViewHolder(view: View) : RecyclerView.ViewHolder(view)

