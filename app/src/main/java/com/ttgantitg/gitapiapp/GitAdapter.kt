package com.ttgantitg.gitapiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ttgantitg.gitapiapp.data.model.UserRepo

class GitAdapter(var items: List<UserRepo>) : RecyclerView.Adapter<GitAdapter.GitHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHolder
            = GitHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: GitHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class GitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val repoName = itemView.findViewById<TextView>(R.id.repo_name)
        fun bind(item: UserRepo) {
            repoName.text = item.repoName
        }
    }
}