package ru.geekbrains.androidonkotlin_1.repository

import ru.geekbrains.androidonkotlin_1.data.Movie

open class Repository : IRepository {

    private val movies: List<Movie>

    init {

        val movie = Movie(id = 1, title = "Movie 1", year = 1990)

        val movie2 = movie.copy()

        val (a, b, c) = movie2

        val movie3 = Movie(a, b)

        movies = listOf(
            Movie(2,"Movie 1", 1991),
            Movie(3,"Movie 2", 1992),
            Movie(4,"Movie 3", 1993),
            Movie(5,"Movie 4", 1994),
            movie,
            movie2,
            movie3,
            Movie(15,"Movie 4", 1995),
            Movie(16,"Movie 4", 1996),
            Movie(17,"Movie 4", 1997)
        )
    }

    override fun getMovies(): List<Movie> {
        return movies
    }
}

interface IRepository{
    fun getMovies(): List<Movie>
}

object RepositorySingle : IRepository {

    private val movies: List<Movie> = listOf(
        Movie(2,"Movie 1", 1991),
        Movie(3,"Movie 2", 1992),
        Movie(4,"Movie 3", 1993),
        Movie(5,"Movie 4", 1994),
        Movie(),
        Movie(6)
    )

    override fun getMovies(): List<Movie> {
        return movies
    }
}

inline fun getRepository(): IRepository{
    return Repository()
}