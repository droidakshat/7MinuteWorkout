package com.example.a7minutesworkout

class ExerciseModel  (
    private var id:Int,
    private var name:String,
    private var image:Int,
    private var isCompleted:Boolean,
    private var isSelected:Boolean

){


    fun getID():Int{
        return id
    }
    fun setID(id:Int){
        this.id=id
    }
    fun getname():String{
        return name
    }
    fun getImage():Int{
        return image
    }
    fun setImage(image:Int){
        this.image=image
    }
    fun setName(name:String){
        this.name=name
    }
    fun getIsComplete():Boolean{
        return isCompleted
    }
    fun setIsComplete(isCompleted: Boolean){
        this.isCompleted=isCompleted
    }
    fun getIsSelected():Boolean {
        return isSelected
    }
    fun setIsselectedd(isSelected: Boolean){
        this.isSelected=isSelected
    }



}