package ru.geekbrains.androidonkotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import ru.geekbrains.androidonkotlin_1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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