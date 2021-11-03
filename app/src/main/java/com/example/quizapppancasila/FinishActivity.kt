package com.example.quizapppancasila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class FinishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvProfileName : TextView
    private lateinit var tvCorrectAnswer : TextView
    private lateinit var btnFinish : Button
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)


        val username = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswer = intent.getStringExtra(Constants.CORRECT_ANSWERS)
        tvProfileName = findViewById(R.id.tv_profile_name)
        tvProfileName.text = "Selamat, $username !"
        tvCorrectAnswer = findViewById(R.id.tv_score)
        tvCorrectAnswer.text = "Anda menjawab benar sebanyak $correctAnswer dari 10 soal"
        btnFinish = findViewById(R.id.btn_finish)
        btnFinish.setOnClickListener(this)
    }
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "ketuk lagi untuk keluar", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    override fun onClick(p0: View?) {
        finish()
    }
}