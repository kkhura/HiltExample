package com.kkhura.hiltexample

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object Custoenstion {
    @BindingAdapter("data")
    @JvmStatic
    fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: List<T>?) {
        data?.let {
            (recyclerView.adapter as? BindableAdapter<T>)?.setData(data)
        }
    }

    @BindingAdapter("adapter")
    @JvmStatic
    fun setRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

}