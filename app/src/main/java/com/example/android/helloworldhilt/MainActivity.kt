package com.example.android.helloworldhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helloworldhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// @AndroidEntryPoint generates an individual Hilt component for each Android class in your project
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            textViewFromInject.text = viewModel.text
            textViewFromService.text = viewModel.getMessage()
        }
        val view = binding.root
        setContentView(view)
    }
}