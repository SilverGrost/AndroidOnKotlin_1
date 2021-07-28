package ru.geekbrains.androidonkotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin_1.R
import ru.geekbrains.androidonkotlin_1.repository.getRepository

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerMovie: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMovie = findViewById(R.id.recyclerMovie)
        val adapter = MovieAdaptor.getInstance(getRepository())
        recyclerMovie.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(
                    this@MainActivity,
                    "Нажата кнопка",
                    Toast.LENGTH_SHORT
            ).show()
        }
    }
}