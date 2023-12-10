package com.example.recyclerviewexercise.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.R
import com.example.recyclerviewexercise.databinding.WisataItemBinding
import com.example.recyclerviewexercise.model.WisataModel

class RvWisataAdapter(private val list: List<WisataModel>) :
    RecyclerView.Adapter<RvWisataAdapter.ViewHolder>() {

    class ViewHolder(val binding: WisataItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WisataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivWisata.setImageResource(this.image)
                binding.tvWisata.text = this.name
                binding.tvDesc.text = this.desc
            }
        }
    }
}