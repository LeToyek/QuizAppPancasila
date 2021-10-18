package com.example.quizapppancasila

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart : Button
    private lateinit var edt_name : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        edt_name = findViewById(R.id.et_name)
        btnStart = findViewById(R.id.btn_start)
        btnStart.setOnClickListener {
            if (edt_name.text.toString().isEmpty()){
                Toast.makeText(this,"Masukkan nama terlebih dahulu ",Toast.LENGTH_SHORT).show()
            }else{
                val Intent = Intent(this,QuizQuestion::class.java)
                startActivity(Intent)
                finish()
            }
        }
    }
}