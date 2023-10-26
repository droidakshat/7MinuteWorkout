package com.example.a7minutesworkout

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.a7minutesworkout.databinding.ActivityBmiBinding
import com.example.a7minutesworkout.databinding.DialogEntervalueBinding
import com.example.a7minutesworkout.databinding.DialogExitBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title="BMI Calculator"

        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
         //   cuatomDialogforbackbutton()
            onBackPressed()
        }
        binding?.btnresultbmi?.setOnClickListener {
            if(validateMatricUnits()){
                val heightvalue:Float=binding?.etMetricUnitheight?.text.toString().toFloat()/100

                val weightvalue:Float=binding?.etMetricUnitWieght?.text.toString().toFloat()

                val bmi=weightvalue/(heightvalue*heightvalue)
                displayBMIresult(bmi)
            }
            else{
                val customdialog = Dialog(this)
                val dialogBinding= DialogEntervalueBinding.inflate(layoutInflater)
                customdialog.setContentView(dialogBinding.root)
                customdialog.setCanceledOnTouchOutside(false)
//        dialogBinding.blCustomYes.setOnClickListener{
//            this@ExcerciseActivity.finish()
//            customdialog.dismiss()
//
//        }
                dialogBinding.blCustomOk.setOnClickListener{
                    customdialog.dismiss()

                }
                customdialog.show()

            }
        }
    }
    private fun validateMatricUnits():Boolean{
        var isvalid=true
        if(binding?.etMetricUnitWieght?.text.toString().isEmpty()){
            isvalid=false
        }else if(binding?.etMetricUnitheight?.text.toString().isEmpty()){
            isvalid=false
        }
        return isvalid
    }
    private fun displayBMIresult(bmi:Float){
        var bmiLable :String="unknown"
        var bmiDescription:String="Unknown"

        if(bmi.compareTo(15f)<=0){
            bmiLable="very severely underweight"
            bmiDescription="Oops!You really need to take better care of yourself!Eat more."
        }
        else if(bmi.compareTo(16f)>0&&bmi.compareTo(18f)<=0){
            bmiLable="Underwieght"
            bmiDescription="You are underwieght!Eat more healthy food"
        }else if(bmi.compareTo(18.5f)>0&&bmi.compareTo(25f)<=0){
            bmiLable="Normal"
            bmiDescription="Congratulation! You are in a good shape!"
        }
        else if(bmi.compareTo(25f)>0&&bmi.compareTo(30f)<=0){
            bmiLable="Overweight"
            bmiDescription="Oops!You are really need to take care of yourself!Workout is the key"

        }else if(bmi.compareTo(30f)>0&&bmi.compareTo(100f)<=0){
            bmiLable="Severely Overwieght"
            bmiDescription="OMG!You need to workout take care of your body its never too late!"
        }
        val bmiValue=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()


        binding?.llDisplayBmiresult?.visibility= View.VISIBLE
        binding?.tvYourBMIValue?.text=bmiValue
        binding?.tvYourBMIType?.text=bmiLable
        binding?.tvYourBMIDescription?.text=bmiDescription

    }
}