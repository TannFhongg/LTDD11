package com.example.recyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top,
                systemBars.right, systemBars.bottom)
            insets
        }
        val id = intent.getIntExtra("ANIMAL_ID", 0)
        val name = intent.getStringExtra("ANIMAL_NAME") ?:"Unknown"
        val description =
            intent.getStringExtra("ANIMAL_DESCRIPTION") ?: "No description available"
        val idTextView: TextView = findViewById(R.id.idTextView)
        val nameTextView: TextView =
            findViewById(R.id.nameTextView)
        val descriptionTextView: TextView =
            findViewById(R.id.descriptionTextView)
        idTextView.text = "ID: $id"
        nameTextView.text = "Name: $name"
        descriptionTextView.text = "Description: $description"
    }
}