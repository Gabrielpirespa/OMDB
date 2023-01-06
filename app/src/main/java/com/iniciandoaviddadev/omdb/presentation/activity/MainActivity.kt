package com.iniciandoaviddadev.omdb.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iniciandoaviddadev.omdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}