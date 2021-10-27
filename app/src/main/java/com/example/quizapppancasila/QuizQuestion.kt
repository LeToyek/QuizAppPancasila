package com.example.quizapppancasila

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress : TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage : ImageView
    private lateinit var tvOptionOne : TextView
    private lateinit var tvOptionTwo : TextView
    private lateinit var tvOptionThree : TextView
    private lateinit var tvOptionFour : TextView
    private lateinit var btnSubmit : Button
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOption : Int = 0


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
        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionList = Constants.getQuestion()

        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }
    private fun setQuestion(){
        mCurrentPosition = 1
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionView()

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,tvOptionOne)
        options.add(1,tvOptionTwo)
        options.add(2,tvOptionThree)
        options.add(3,tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_1->{
                selectedOptionView(tvOptionOne,0)
            }
            R.id.tv_option_2->{
                selectedOptionView(tvOptionTwo,1)
            }
            R.id.tv_option_3->{
                selectedOptionView(tvOptionThree, 2)
            }
            R.id.tv_option_4->{
                selectedOptionView(tvOptionFour,3)
            }
            R.id.btn_submit->{
                if(mSelectedOption ==0 ){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else->{
                            Toast.makeText(this,"Selamat, Anda telah menyelesaikan quizx",Toast.LENGTH_SHORT)
                                .show()

                        }
                    }
                }
            }
        }
    }
    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionView();
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border
        )
    }

}