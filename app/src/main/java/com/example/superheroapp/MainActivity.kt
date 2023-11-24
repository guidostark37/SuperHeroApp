package com.example.superheroapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.superheroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var musica :MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        musica = MediaPlayer.create(this,R.raw.ljsonido)
        //musica.start()
        binding.imageView.animate().setStartDelay(1000).setDuration(6000).scaleY(2f).scaleX(1.5f).withEndAction{
                   startActivity(Intent(this,Home::class.java))
            //musica.stop()
        }   .start()
        pantallaCompleta()

    }

    private fun pantallaCompleta() {
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).hide(WindowInsetsCompat.Type.systemBars())
    }

}