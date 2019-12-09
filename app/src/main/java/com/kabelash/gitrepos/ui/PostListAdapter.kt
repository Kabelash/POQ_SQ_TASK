package com.kabelash.gitrepos.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kabelash.gitrepos.R
import com.kabelash.gitrepos.databinding.ListItemBinding
import com.kabelash.gitrepos.model.Github

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private lateinit var postList:List<Github>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList:List<Github>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = PostViewModel()

        fun bind(post:Github){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, binding.postTitle.text, Toast.LENGTH_SHORT).show()

                val intent = Intent(binding.root.context, DetailsActivity::class.java)
                //intent.putExtra(REPO_NAME, binding.postTitle.text)

                binding.root.context.startActivity(intent)
            }
        }

    }
}