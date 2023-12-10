package com.example.recyclerviewexercise

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexercise.adapters.RvWisataAdapter
import com.example.recyclerviewexercise.databinding.ActivityMainBinding
import com.example.recyclerviewexercise.model.WisataModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapterKeren:RvWisataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setRvAdapter()
    }

    private fun init() {
        binding.rvExample.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun setRvAdapter() {

        val dataList:MutableList<WisataModel> = mutableListOf()

        nameWisata().forEachIndexed { index, name ->
            dataList.add(WisataModel(imageWisata().get(index),name,descWisata()[index]))
        }

        Log.d("ISI DATANYA ",dataList.toString())
        adapterKeren = RvWisataAdapter(dataList)
        binding.rvExample.adapter = adapterKeren

    }

    private fun nameWisata():Array<String> = resources.getStringArray(R.array.data_name)
    private fun descWisata():Array<String> = resources.getStringArray(R.array.data_description)

    private fun imageWisata():List<Int> = listOf(
        R.drawable.asta,
        R.drawable.wiliam,
        R.drawable.yami,
        R.drawable.licth,
        R.drawable.leopold,
        R.drawable.rill
    )
}