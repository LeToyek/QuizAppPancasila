package com.example.quizapppancasila

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

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
        btnSubmit.isEnabled = false
        btnSubmit.setBackgroundColor(Color.parseColor("#7A8089"))
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit.text = "Finish"
        }else{
            btnSubmit.text = "submit"
        }

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
                selectedOptionView(tvOptionOne,1)
                btnSubmit.isEnabled = true
                btnSubmit.setBackgroundColor(Color.parseColor("#F9AA33"))
            }
            R.id.tv_option_2->{
                selectedOptionView(tvOptionTwo,2)
                btnSubmit.isEnabled = true
                btnSubmit.setBackgroundColor(Color.parseColor("#F9AA33"))
            }
            R.id.tv_option_3->{
                selectedOptionView(tvOptionThree, 3)
                btnSubmit.isEnabled = true
                btnSubmit.setBackgroundColor(Color.parseColor("#F9AA33"))
            }
            R.id.tv_option_4->{
                selectedOptionView(tvOptionFour,4)
                btnSubmit.isEnabled = true
                btnSubmit.setBackgroundColor(Color.parseColor("#F9AA33"))
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
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption,R.drawable.incorrect_option_border)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit.text = "Selesai"
                    }else{
                        btnSubmit.text = "Pertanyaan Berikutnya"
                    }
                    mSelectedOption = 0
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
    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1->{
                tvOptionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}

