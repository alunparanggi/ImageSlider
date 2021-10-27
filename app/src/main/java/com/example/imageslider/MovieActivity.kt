package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.imageslider.DataDummy.getMovies
import com.example.imageslider.databinding.ActivityMovieBinding
import java.util.ArrayList

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView(getMovies())
        val imgSlider = findViewById<ImageSlider>(R.id.img_sliders)
        val baseUrl = "https://image.tmdb.org/t/p/w500"
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("$baseUrl/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg", ""))
        imageList.add(SlideModel("$baseUrl/2cdrhlf3hvvueGyQDx0u8jpWvQR.jpg", ""))
        imageList.add(SlideModel("$baseUrl/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg", ""))
        imageList.add(SlideModel("$baseUrl/x6E7DS5ZcMoCITjkO0RiLLQ9Nb0.jpg", ""))
        imageList.add(SlideModel("$baseUrl/ux6gkGSKNFtp2NFYxwYFxVWdnGa.jpg", ""))

        imgSlider.setImageList(imageList, ScaleTypes.FIT)
    }

    fun setupRecyclerView(movies: List<MovieEntity>) {
        val adapter = MovieAdapter(
            MovieAdapter.OnClickListener {
                Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
            }
        )
        adapter.submitList(movies)
        binding.rvMovies.adapter = adapter
    }
}

