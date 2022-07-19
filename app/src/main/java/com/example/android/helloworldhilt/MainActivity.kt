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

    @Inject lateinit var service: MessageService

    // @TypeAClient at field injection.
    @TypeAClient
    @Inject lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            textViewFromInject.text = viewModel.text
            textViewFromService.text = viewModel.getMessage()
            textViewFromExternalLibrary.text = viewModel.getMessageFromExternalLibrary()
            textViewFromThirdModuleService.text = service.generateMessage()
            textViewFromThirdModuleClient.text = client.generateMessage()
        }
        val view = binding.root
        setContentView(view)
    }
}