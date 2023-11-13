package kz.just_code.mvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.just_code.mvvm.repository.Movie
import kz.just_code.mvvm.repository.MovieRepository

class MovieViewModel(
    private var repository:MovieRepository
):ViewModel() {


    private var _faqListLiveData= MutableLiveData<List<Movie>>()
    var faqListLiveData:LiveData<List<Movie>> = _faqListLiveData

    init {
        getData()
    }

    private fun getData(){
        val data = repository.getFaqList()
        _faqListLiveData.postValue(data)
    }
}