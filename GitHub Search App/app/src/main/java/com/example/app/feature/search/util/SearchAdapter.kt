package com.example.app.feature.search.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
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
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateData(items: ArrayList<Item>) {
        val diffCallback = ItemDiffCallback(mItems, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
        diffResult.dispatchUpdatesTo(this)
    }

    fun clearData() {
        mItems.clear()
        notifyDataSetChanged()
    }
}

class RowViewHolder(view: View) : RecyclerView.ViewHolder(view)

