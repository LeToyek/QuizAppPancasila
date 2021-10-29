package com.example.quizapppancasila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinishActivity : AppCompatActivity() {

    private lateinit var tvProfileName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tvProfileName = findViewById(R.id.tv_profile_name)
        tvProfileName.text = username
    }
}