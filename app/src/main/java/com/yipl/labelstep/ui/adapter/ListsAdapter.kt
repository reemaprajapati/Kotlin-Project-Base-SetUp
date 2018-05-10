package com.yipl.labelstep.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yipl.labelstep.R
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.databinding.LayoutItemUserBinding
import com.yipl.labelstep.ui.PostViewModel
import java.util.*

class ListsAdapter(var context: Context) : RecyclerView.Adapter<ListsAdapter.ListViewHolder>() {

    private var data: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: LayoutItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_item_user, parent, false);
        return ListViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Post>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ListViewHolder(binding: LayoutItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel: PostViewModel

        init {
            viewModel = PostViewModel()
            binding.viewModel = viewModel
        }

        fun bind(item: Post) {
            viewModel.post = item
            Log.e("ViewModel", item.title)
//            // TODO: Bind the data with View
//            setOnClickListener {
//                // TODO: Handle on click
//            }
        }
    }
}