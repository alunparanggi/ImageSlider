package com.example.imageslider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgSlider = findViewById<ImageSlider>(R.id.img_slider)
        val baseUrl = "https://image.tmdb.org/t/p/w500"
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("$baseUrl/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg", "Venom"))
        imageList.add(SlideModel("$baseUrl/2cdrhlf3hvvueGyQDx0u8jpWvQR.jpg", "Halloween Kills"))
        imageList.add(SlideModel("$baseUrl/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg", "Free Guy"))
        imageList.add(SlideModel("$baseUrl/x6E7DS5ZcMoCITjkO0RiLLQ9Nb0.jpg", "Dune"))
        imageList.add(SlideModel("$baseUrl/ux6gkGSKNFtp2NFYxwYFxVWdnGa.jpg", "Kin"))

        imgSlider.setImageList(imageList, ScaleTypes.FIT)

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            startActivity(Intent(this@MainActivity, MovieActivity::class.java))
        }
    }
}