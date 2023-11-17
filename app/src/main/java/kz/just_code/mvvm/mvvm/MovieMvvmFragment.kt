package kz.just_code.mvvm.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.mvvm.MovieAdapter
import kz.just_code.mvvm.databinding.FragmentMovieListBinding
import kz.just_code.mvvm.repository.MovieRepositoryImpl

class MovieMvvmFragment:Fragment(){

    private lateinit var binding: FragmentMovieListBinding
    private val adapter: MovieAdapter = MovieAdapter()
    private val viewModel:MovieViewModel = MovieViewModel(MovieRepositoryImpl())

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

        binding.listView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.listView.adapter = adapter

        adapter.click = {
            findNavController().navigate(
                MovieMvvmFragmentDirections.actionFaqMvvmFragmentToMovieDetailsFragment(it)
            )
        }
        viewModel.movieListLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
}