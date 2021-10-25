package com.example.quizapppancasila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestion : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress : TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage : ImageView
    private lateinit var tvOptionOne : TextView
    private lateinit var tvOptionTwo : TextView
    private lateinit var tvOptionThree : TextView
    private lateinit var tvOptionFour : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        progressBar = findViewById(R.id.progreesBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.img_question)
        tvOptionOne = findViewById(R.id.tv_option_1)
        tvOptionTwo = findViewById(R.id.tv_option_2)
        tvOptionThree = findViewById(R.id.tv_option_3)
        tvOptionFour = findViewById(R.id.tv_option_4)

        val questionList = Constants.getQuestion()
        Log.i("Question size : ","${questionList.size}")

        val currentPosition = 1
        val question : Question? = questionList[currentPosition-1]

        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour



    }
}