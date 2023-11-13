package kz.just_code.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kz.just_code.mvvm.databinding.FragmentMovieDetailsBinding
import kotlin.concurrent.timerTask

class MovieDetailsFragment:Fragment() {
    private lateinit var binding:FragmentMovieDetailsBinding
    private val args:MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val item = args.movieItem
            title.text = getString(item.title)
            image.setImageResource(item.image)
            description.text = getString(item.description)

        }
    }
}