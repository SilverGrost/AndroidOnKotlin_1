package ru.geekbrains.androidonkotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin_1.R
import ru.geekbrains.androidonkotlin_1.data.Movie
import ru.geekbrains.androidonkotlin_1.repository.IRepository
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


            val repository: IRepository = getRepository()
            val movies: List<Movie> = repository.getMovies()

            println("1. Цикл for")
            for(movie in movies) {
                println(movie.title + " (" + movie.year + ")")
            }

            println("2. Цикл ...")
            for(i in 0..movies.size - 1) {
                println(movies.get(i).title + " (" + movies.get(i).year + ")")
            }

            println("3. Цикл for с dowTo")
            for(i in movies.size - 1 downTo 0 step 2) {
                println(movies.get(i).title + " (" + movies.get(i).year + ")")
            }

            println("4. Цикл for с until")
            for (i in 0 until movies.size) {
                println(movies.get(i).title + " (" + movies.get(i).year + ")")
            }

        }
    }
}