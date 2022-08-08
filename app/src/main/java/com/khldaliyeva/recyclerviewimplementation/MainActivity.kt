package com.khldaliyeva.recyclerviewimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvItems: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItems = findViewById(R.id.rvItems)

        val exampleItems = generateExampleItems(500)
        rvItems.adapter = ExampleAdapter(exampleItems)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.setHasFixedSize(true)
    }

    private fun generateExampleItems(size: Int): List<ExampleItem> {
        val exampleItems = ArrayList<ExampleItem>()

        for(i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_baseline_outdoor_grill
                else -> R.drawable.ic_baseline_pedal_bike
            }

            val exampleItem = ExampleItem(drawable, "Item $i", "Description")
            exampleItems += exampleItem
        }

        return exampleItems
    }
}