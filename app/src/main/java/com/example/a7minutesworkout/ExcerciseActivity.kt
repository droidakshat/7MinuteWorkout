package com.example.a7minutesworkout

import android.app.Activity
import android.content.ActivityNotFoundException
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minutesworkout.databinding.ActivityExcerciseBinding
import com.example.a7minutesworkout.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class ExcerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding : ActivityExcerciseBinding? =null

    private var restTimer:CountDownTimer?=null
    private var restProcess=0
    private var tts:TextToSpeech?=null
    private var player:MediaPlayer?=null
    private var exerciseAdapter:ExerciseStaticAdaptor?=null


    private var excerciseTimer:CountDownTimer?=null
    private var excerciseProcess=0
    private var excerciseList:ArrayList<ExerciseModel>?=null
    private var currentExercisePosition=-1
    private var resultPosition=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbar)

        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        excerciseList=Constants.defaultExerciseList()

        tts= TextToSpeech(this,this)

        binding?.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
setupRestView()
        setupExerciseRecycleview()


    }
    private fun setupExerciseRecycleview() {
        binding?.rvExerciseStatus?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        exerciseAdapter= ExerciseStaticAdaptor(excerciseList!!)
        binding?.rvExerciseStatus?.adapter=exerciseAdapter

    }


    private fun setupRestView(){

        try{
            val soundURI= Uri.parse("android.resource://com.example.a7minutesworkout/"+R.raw.press_start)
            player=MediaPlayer.create(applicationContext,soundURI)
            player?.isLooping=false
            player?.start()
        }catch (e:Exception){
            e.printStackTrace()
        }


       // binding?.rvExerciseStatus?.visibility=View.VISIBLE
        binding?.flrestview?.visibility=View.VISIBLE
        binding?.tvtitle?.visibility=View.VISIBLE
        binding?.tvExeciseName?.visibility=View.INVISIBLE
        binding?.tvResultName?.visibility=View.VISIBLE
        binding?.flExerciseView?.visibility=View.INVISIBLE
        binding?.ivImage?.visibility=View.INVISIBLE

        if(restTimer!=null){
            restTimer?.cancel()
            restProcess=0
        }
        setRestProgressbar()
    }
    private fun setupExerciseView(){
        //binding?.rvExerciseStatus?.visibility=View.INVISIBLE
        binding?.flrestview?.visibility=View.INVISIBLE
        binding?.tvtitle?.visibility=View.INVISIBLE
        binding?.tvExeciseName?.visibility=View.VISIBLE
        binding?.tvResultName?.visibility=View.INVISIBLE
        binding?.flExerciseView?.visibility=View.VISIBLE
        binding?.ivImage?.visibility=View.VISIBLE
        if(excerciseTimer!=null){
            excerciseTimer?.cancel()
            excerciseProcess=0
        }
        speakOut(excerciseList!![currentExercisePosition].getname())

        binding?.ivImage?.setImageResource(excerciseList!![currentExercisePosition].getImage())
        binding?.tvExeciseName?.text=excerciseList!![currentExercisePosition].getname()
        binding?.tvResultName?.text=excerciseList!![resultPosition].getname()

        setExcerciseProgressbar()
    }
    private fun setRestProgressbar(){
        binding?.progressBar?.progress=restProcess

        restTimer= object: CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
               restProcess++
                binding?.progressBar?.progress=10-restProcess
                binding?.tvtimer?.text=(10-restProcess).toString()
                if(binding?.progressBar?.progress==3){
                    try{
                        val soundURI= Uri.parse("android.resource://com.example.a7minutesworkout/"+R.raw.count)
                        player=MediaPlayer.create(applicationContext,soundURI)
                        player?.isLooping=false
                        player?.start()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }

            override fun onFinish() {
                //Toast.makeText(this@ExcerciseActivity, "Time complete!", Toast.LENGTH_SHORT).show()
                val context = this@ExcerciseActivity // Replace with your activity's name
                val rootView = binding?.root // Replace with your root layout view
               // val snackbar = rootView?.let { Snackbar.make(it, "Time complete!", Snackbar.LENGTH_LONG) }
               // snackbar?.show()
                currentExercisePosition++
                resultPosition++
                excerciseList!![currentExercisePosition].setIsselectedd(true)
                exerciseAdapter!!.notifyDataSetChanged()
                setupExerciseView()
            }

        }.start()
    } private fun setExcerciseProgressbar(){
        binding?.progressBarExcercise?.progress=excerciseProcess

        excerciseTimer= object: CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                excerciseProcess++
                binding?.progressBarExcercise?.progress=30-excerciseProcess
                binding?.tvtimerExcercise?.text=(30-excerciseProcess).toString()
                if(binding?.progressBarExcercise?.progress==10){
                    try{
                        val soundURI= Uri.parse("android.resource://com.example.a7minutesworkout/"+R.raw.clock)
                        player=MediaPlayer.create(applicationContext,soundURI)
                        player?.isLooping=false
                        player?.start()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }

            override fun onFinish() {
                //Toast.makeText(this@ExcerciseActivity, "Time complete!", Toast.LENGTH_SHORT).show()
                val context = this@ExcerciseActivity // Replace with your activity's name
                val rootView = binding?.root // Replace with your root layout view
               // val snackbar = rootView?.let { Snackbar.make(it, "Take a break!!", Snackbar.LENGTH_LONG) }
               // snackbar?.show()

                excerciseList!![currentExercisePosition].setIsselectedd(false)
                excerciseList!![currentExercisePosition].setIsComplete(true)
                exerciseAdapter!!.notifyDataSetChanged()

                if(currentExercisePosition<excerciseList?.size!!-1){
                    setupRestView()
                }else{
                    Toast.makeText(
                        this@ExcerciseActivity,
                        "congratulations!You have completed the 7 minutes workout",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer!=null){
            restTimer?.cancel()
            restProcess=0
        }
        if(excerciseTimer!=null){
            excerciseTimer?.cancel()
            excerciseProcess=0
        }
            if (tts!=null){
                tts!!.stop()
                tts!!.shutdown()
            }
        if(player!=null){
            player!!.stop()
        }

        binding=null
    }

    override fun onInit(status :Int) {
        if(status==TextToSpeech.SUCCESS){
            val result=tts?.setLanguage(Locale.ENGLISH)

            if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","the language is not supported!")
            }
        }else{
            Log.e("TTS","Initialization failed!")
        }

    }
    private fun speakOut(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    // private fun snack(view: View){
     //   val snack = Snackbar.make(view,"time complete",Snackbar.LENGTH_LONG)
       // snack.show()
    //}
}