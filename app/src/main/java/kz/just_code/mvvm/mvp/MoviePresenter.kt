package kz.just_code.mvvm.mvp

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kz.just_code.mvvm.R
import kz.just_code.mvvm.repository.Movie
import kz.just_code.mvvm.repository.MovieRepository
import kz.just_code.mvvm.repository.MovieRepositoryImpl

class MoviePresenter(
    private val view:MovieScreen.View
):MovieScreen.Presenter {
    private val repository: MovieRepository = MovieRepositoryImpl()


    init {
        getData()
    }


    override fun getData() {
        val data = repository.getFaqList()
        view.showData(data)
    }

    override fun openDetails(movie: Movie) {
        (view as Fragment).findNavController().navigate(
            MovieMvpFragmentDirections.actionFaqMvpFragmentToMovieDetailsFragment(movie)
        )
    }

}