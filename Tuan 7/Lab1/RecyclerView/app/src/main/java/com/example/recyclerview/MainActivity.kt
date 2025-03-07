package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalAdapter: AnimalAdapter
    private val animals = listOf(
        Animal(1, "Lion", "A large wild cat."),
        Animal(2, "Tiger", "The largest cat species."),
        Animal(3, "Elephant", "The largest land animal."),
        Animal(4, "Giraffe", "Tallest land animal."),
        Animal(5, "Zebra", "Striped horse-like animal.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main
        )) { v, insets -> val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        animalAdapter = AnimalAdapter(animals) { animal ->
            showAnimalDetails(animal)
        }
        recyclerView.adapter = animalAdapter
    }
    private fun showAnimalDetails(animal: Animal) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("ANIMAL_ID", animal.id)
        intent.putExtra("ANIMAL_NAME", animal.name)
        intent.putExtra("ANIMAL_DESCRIPTION",
            animal.description)
        startActivity(intent)
    }
}