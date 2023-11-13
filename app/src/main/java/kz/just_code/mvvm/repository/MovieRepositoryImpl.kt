package kz.just_code.mvvm.repository

import kz.just_code.mvvm.R

class MovieRepositoryImpl:MovieRepository {

    private var movieList: List<Movie> = listOf(

    )
    override fun getFaqList(): List<Movie> {
        return movieList.ifEmpty { getRemoteMovie() }
    }
    private fun getRemoteMovie():List<Movie>{
        val list:MutableList<Movie> = mutableListOf(
            Movie(0, R.string.title_1, R.string.description_1, R.drawable.indiana_jones),
            Movie(1, R.string.title_2, R.string.description_2, R.drawable.spider_man),
            Movie(2, R.string.title_3, R.string.description_3, R.drawable.elemental),
            Movie(3, R.string.title_4, R.string.description_4, R.drawable.transformers),
        )
        movieList = list
        return list
    }
}