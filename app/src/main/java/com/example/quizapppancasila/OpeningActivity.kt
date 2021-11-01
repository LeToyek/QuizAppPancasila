package com.example.quizapppancasila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.graphics.Typeface
import android.widget.TextView


class OpeningActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this, MainActivity ::class.java)
            startActivity(mainIntent)
            finish()
        }, 2000)

    }
}