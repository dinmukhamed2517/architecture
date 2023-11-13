package kz.just_code.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.mvvm.databinding.ItemMovieBinding
import kz.just_code.mvvm.repository.Movie

class MovieAdapter: ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil) {

    var click: ((Movie) -> Unit)? = null

    object MovieDiffUtil:DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem

        }

    }

    inner class MovieViewHolder(private val binding:ItemMovieBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Movie){
            with(binding){
                title.text = itemView.context.getString(item.title)
                image.setImageResource(item.image)
            }
            itemView.setOnClickListener {
                click?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}