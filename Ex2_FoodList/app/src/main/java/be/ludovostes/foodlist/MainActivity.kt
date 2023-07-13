package be.ludovostes.foodlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.ludovostes.foodlist.databinding.ActivityMainBinding

// 1.1
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}