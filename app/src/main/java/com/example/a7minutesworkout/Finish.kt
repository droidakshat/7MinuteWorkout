package com.example.a7minutesworkout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7minutesworkout.databinding.ActivtyFinishBinding

class Finish : AppCompatActivity() {
   private var binding: ActivtyFinishBinding?=null
    private var excerciseList:ArrayList<ExerciseModel>?=null
    //private var randomExercise:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivtyFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        setSupportActionBar(binding?.toolbarfinal)
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarfinal?.setNavigationOnClickListener {
            onBackPressed()
            finish()

        }
        excerciseList=Constants.defaultExerciseList()
       var  randomExercise= getRandomExercise()
        binding?.tvQuote?.text = randomExercise?.getquote()
        binding?.tvQname?.text =  randomExercise?.getqname()


    }
    private fun getRandomExercise(): ExerciseModel? {
        if (excerciseList.isNullOrEmpty()) {
            return null
        }

        val randomIndex = (0 until excerciseList!!.size).random()
        return excerciseList!![randomIndex]
    }
}