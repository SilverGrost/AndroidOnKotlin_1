package ru.geekbrains.androidonkotlin_1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin_1.R
import ru.geekbrains.androidonkotlin_1.data.Movie
import ru.geekbrains.androidonkotlin_1.repository.IRepository

class MovieAdaptor(private val repository: IRepository) :

    RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>() {
    class MovieViewHolder(val item: View) : RecyclerView.ViewHolder(item) {

        private val title: TextView

        private val year: TextView

        init {
            title = item.findViewById(R.id.title)
            year = item.findViewById(R.id.year)
        }

        fun bind(movie: Movie) {
            title.text = movie.title
            year.text = movie.year.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(repository.getMovies()[position])
    }

    override fun getItemCount(): Int {
        return repository.getMovies().size
    }

    companion object {

        fun getInstance(repository: IRepository): MovieAdaptor {
            return MovieAdaptor(repository)
        }
    }



}