package com.example.a7minutesworkout

object Constants {

    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

// Add Jumping Jacks
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.jumpingjack,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

// Add Pushups
        val pushups = ExerciseModel(
            2,
            "Pushups",
            R.drawable.pushupp,
            false,
            false
        )
        exerciseList.add(pushups)

// Add Pushup Rotation
        val pushupRotation = ExerciseModel(
            3,
            "Pushup Rotation",
            R.drawable.pushuprotation,
            false,
            false
        )
        exerciseList.add(pushupRotation)

// Add Burpees
        val burpees = ExerciseModel(
            4,
            "Burpees",
            R.drawable.birpie,
            false,
            false
        )
        exerciseList.add(burpees)

// Add Squats
        val squats = ExerciseModel(
            5,
            "Squats",
            R.drawable.squat,
            false,
            false
        )
        exerciseList.add(squats)

// Add Wall Sit
        val wallSit = ExerciseModel(
            6,
            "Wall Sit",
            R.drawable.wallsit,
            false,
            false
        )
        exerciseList.add(wallSit)

// Add Lunges
        val lunges = ExerciseModel(
            7,
            "Lunges",
            R.drawable.lunges,
            false,
            false
        )
        exerciseList.add(lunges)

// Add Plank
        val plank = ExerciseModel(
            8,
            "Plank",
            R.drawable.plank,
            false,
            false
        )
        exerciseList.add(plank)

// Add Tricep Chair Dips


        val sidePlank = ExerciseModel(
            9,
            "Side Plank",
            R.drawable.sideplank,
            false,
            false
        )
        exerciseList.add(sidePlank)
        val tricepChairDips = ExerciseModel(
            10,
            "Tricep Chair Dips",
            R.drawable.tribichair,
            false,
            false
        )
        exerciseList.add(tricepChairDips)

        val crunches = ExerciseModel(
            11,
            "Crunches",
            R.drawable.crunches,
            false,
            false
        )
        exerciseList.add(crunches)

        val legRaise = ExerciseModel(
            12,
            "Leg Raise",
            R.drawable.legrise,
            false,
            false
        )
        exerciseList.add(legRaise)

        return exerciseList
    }
}