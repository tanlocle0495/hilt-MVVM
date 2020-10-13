package com.loc.lt.android.mvvm.ui.demo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loc.lt.android.mvvm.databinding.ItemLayoutBinding
import com.loc.lt.android.mvvm.model.User

class DemoAdapter : RecyclerView.Adapter<DemoAdapter.VH>() {
    private var items: List<User> = ArrayList()

    class VH(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setupData(data: User) {
            binding.textViewUserEmail.apply { text = data.email }
            binding.textViewUserName.apply { text = data.name }
        }
    }

    fun setData(items: List<User>) {
        this.items = items
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.setOnClickListener {
            Log.e("TEST", "TEST")
        }
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setupData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}