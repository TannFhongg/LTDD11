package com.example.animalrecyleview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val itemList = listOf(
            Item(1, "Ho", R.drawable.tiger, "A large wild cat."),
            Item(2, "Huou", R.drawable.huou, "A powerful big cat."),
            Item(3, "Gau", R.drawable.gau, "The largest land animal."),
            Item(4, "Soc", R.drawable.soc, "A tall animal with a long neck."),
            Item(5, "Meo", R.drawable.meo, "A horse-like animal with stripes."),
            Item(6, "Vet", R.drawable.vet, "A black and white bear.")
        )

        val adapter = ItemAdapter(itemList, this)
        recyclerView.adapter = adapter
    }
}
