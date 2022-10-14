package com.example.latihankonsep

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihankonsep.databinding.ListquotesBinding

class ListQuotesAdapter(private val listQuotes: ArrayList<String>) :
    RecyclerView.Adapter<ListQuotesAdapter.ListViewHolder>() {
    class ListViewHolder(val lisQuotesBinding: ListquotesBinding) :
        RecyclerView.ViewHolder(lisQuotesBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ListquotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.lisQuotesBinding.tvQuotes.text = listQuotes[position]
    }

    override fun getItemCount(): Int = listQuotes.size
}