package com.ebrar.mylibrary

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ebrar.mylibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }




    fun loginAction(view: View) {
        val sharedPreferences = this.getSharedPreferences("com.ebrar.mylibrary", MODE_PRIVATE)
        val userName = binding.nameTextView.text.toString()
        val intent = Intent(applicationContext, NextPageActivity::class.java)
        startActivity(intent)

    }


}