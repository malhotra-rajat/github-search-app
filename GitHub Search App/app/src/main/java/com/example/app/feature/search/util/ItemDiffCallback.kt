package com.example.app.feature.search.util

import androidx.recyclerview.widget.DiffUtil
import com.example.app.feature.search.datamodel.Item

/**
 * Created by malho on 15,June,2020
 */
class ItemDiffCallback(val oldItems: ArrayList<Item>, val newItems: ArrayList<Item>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[oldItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[oldItemPosition]
    }

}