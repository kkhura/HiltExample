package com.kkhura.hiltexample.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kkhura.hiltexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.text = mainViewModel.getButtonText()
        binding.btnClick.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))

            /*val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    // There are no request codes
                    val data: Intent? = result.data
                }
            }*/
//            val galleryIntent = Intent(
//                Intent.ACTION_PICK,
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            )
//            val galleryIntent = Intent()
//            galleryIntent.type = "image/*"
//            galleryIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//            galleryIntent.action = Intent.ACTION_GET_CONTENT
//            galleryIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//            startActivityForResult(galleryIntent, 111)
        }
    }
}