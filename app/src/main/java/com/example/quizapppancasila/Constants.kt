package com.example.quizapppancasila

object Constants {
    fun getQuestion () : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question1)

        val question2 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question2)

        val question3 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question3)

        val question4 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question4)

        val question5 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question5)

        val question6 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question6)

        val question7 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question7)

        val question8 = Question(1,"Apakah nama partai ini ?",R.drawable.pdip,"PDIP"
            ,"Gerindra","PKS","PKI",1)
        questionList.add(question8)
        return questionList
    }
}