package kz.just_code.mvvm.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.mvvm.MovieAdapter
import kz.just_code.mvvm.databinding.FragmentMovieListBinding
import kz.just_code.mvvm.repository.Movie

class MovieMvpFragment:Fragment(), MovieScreen.View{
    private lateinit var binding: FragmentMovieListBinding
    private val adapter:MovieAdapter = MovieAdapter()
    private lateinit var presenter: MovieScreen.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MoviePresenter(this)
        binding.listView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.listView.adapter = adapter

        adapter.click = {
            presenter.openDetails(it)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    }

    override fun showData(list: List<Movie>) {
        adapter.submitList(list)
    }
}