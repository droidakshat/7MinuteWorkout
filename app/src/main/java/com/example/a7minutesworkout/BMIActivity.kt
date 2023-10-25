package com.example.a7minutesworkout

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.a7minutesworkout.databinding.ActivityBmiBinding
import com.example.a7minutesworkout.databinding.DialogEntervalueBinding
import com.example.a7minutesworkout.databinding.DialogExitBinding

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
    private fun cuatomDialogforbackbutton(){
//        val customdialog = Dialog(this)
//        val dialogBinding= DialogEntervalueBinding.inflate(layoutInflater)
//        customdialog.setContentView(dialogBinding.root)
//        customdialog.setCanceledOnTouchOutside(false)
////        dialogBinding.blCustomYes.setOnClickListener{
////            this@ExcerciseActivity.finish()
////            customdialog.dismiss()
////
////        }
//        dialogBinding.blCustomOk.setOnClickListener{
//            customdialog.dismiss()
//
//        }
//        customdialog.show()
    }
}