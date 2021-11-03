package com.example.quizapppancasila

object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"
    fun getQuestion () : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,"Siapakah beliau ?",R.drawable.soekarno,"Ir.Soekarno"
            ,"Soekarno Hatta","Ir.Soemarno","Jendral Soedirman",1)
        questionList.add(question1)

        val question2 = Question(1,"Logo apakah ini?",R.drawable.budi_utomo,"PKI"
            ,"Koperasi Indonesia","PDIP","Budi Utomo",4)
        questionList.add(question2)

        val question3 = Question(1,"Kota kelahiran siapakah ini ?",R.drawable.soerabaja,"Soemarni"
            ,"Soemanto","Soekarno","Soekamti",3)
        questionList.add(question3)

        val question4 = Question(1,"Lambang sila ke berapa gambar berikut?",R.drawable.bintang,"kedua"
            ,"ketiga","pertama","keempat",3)
        questionList.add(question4)

        val question5 = Question(1,"Dari manakah tokoh tersebut berasal?",R.drawable.tokoh,"Malang"
            ,"Probolinggo","Aceh","Jember",3)
        questionList.add(question5)
        val question6 = Question(1,"Dari gambar diatas lambang kepala banteng tersebut adalah lambang dari sila ke ?"
        ,R.drawable.sila4,"4","1","2","5",1)
        questionList.add(question6)
        val question7 = Question(1,"Dari gambar diatas lambang pohon beringin tersebut adalah lambang dari sila ke ?",
        R.drawable.wit,"1","2","3","4",3)
        questionList.add(question7)
        val question8 = Question(1,"Dari banyak pahlawan diindonesia,jika dilihat gambar diatas siapakah nama pahlawan tersebut ?"
        ,R.drawable.imambonjol,"Ki Hajar Dewantara", "Tuanku Imam Bonjol","Ir.Soekarno","Douwes Deker",2)
        questionList.add(question8)
        val question9 = Question(1,"Beliau pernah menjabat presiden dengan waktu terlama di Indonesia, nama beliau adalah ?"
            ,R.drawable.soeharto,"DN Aidit","Soepomo","Soeharto","Soekarwo",3)
        questionList.add(question9)
        val question10 = Question(1,"Dikenal sebagai Ahli Strategi Perang, nama beliau adalah ?",
        R.drawable.ahmadyani,"Sanusi","Diponegoro","Luhut","Ahmad Yani",4)
        questionList.add(question10)
        questionList.shuffle();
        return questionList
    }
}