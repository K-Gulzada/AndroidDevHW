package com.example.androiddevhw_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevhw_2.RecyclerAdapter.Item

class RecyclerViewActivity : AppCompatActivity() {

    val recyclerList:ArrayList<Item> = arrayListOf(
        Item("Item 1",R.drawable.ic_blackcat),
        Item("Item 2",R.drawable.ic_blue),
        Item("Item 3",R.drawable.ic_cube),
        Item("Item 4",R.drawable.ic_dragon),
        Item("Item 5",R.drawable.ic_inyan),
        Item("Item 6",R.drawable.ic_light),
        Item("Item 7",R.drawable.ic_3d),
        Item("Item 8",R.drawable.ic_wine))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerAdapter(recyclerList)
        recyclerView.adapter = adapter

      /*  adapter.setData(recyclerList)
        recyclerView.adapter = adapter*/

    }
}