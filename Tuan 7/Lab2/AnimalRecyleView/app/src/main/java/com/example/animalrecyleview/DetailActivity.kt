package com.example.animalrecyleview
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("id", 0)
        val name = intent.getStringExtra("name") ?: "Unknown"
        val description = intent.getStringExtra("description") ?: "No description available."

        val textViewId: TextView = findViewById(R.id.textViewId)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)

        textViewId.text = "ID: $id"
        textViewName.text = "Name: $name"
        textViewDescription.text = "Description: $description"
    }
}
