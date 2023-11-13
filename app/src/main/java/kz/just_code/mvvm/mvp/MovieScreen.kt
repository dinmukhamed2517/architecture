package kz.just_code.mvvm.mvp

import kz.just_code.mvvm.repository.Movie

sealed interface MovieScreen{
    interface View{
        fun showMessage(message:String)
        fun showData(list:List<Movie>)

    }
    interface Presenter{
        fun getData()
        fun openDetails(faq: Movie)
    }
}