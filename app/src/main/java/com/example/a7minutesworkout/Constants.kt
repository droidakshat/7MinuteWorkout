package com.example.a7minutesworkout

object Constants {

    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()


        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.jumpingjack,
            false,
            false,
        "Success is the product of daily habits—not once-in-a-lifetime transformations.",
            "― James Clear"
        )
        exerciseList.add(jumpingJacks)


        val pushups = ExerciseModel(
            2,
            "Pushups",
            R.drawable.pushupp,
            false,
            false,
            "I hated every minute of training, but I said, ‘Don’t quit. Suffer now and live the rest of your life as a champion.",
            "― Muhammad Ali"
        )
        exerciseList.add(pushups)

        val pushupRotation = ExerciseModel(
            3,
            "Pushup Rotation",
            R.drawable.pushuprotation,
            false,
            false,
            "We are what we repeatedly do. Excellence then is not an act but a habit.",
            "― Aristotele"
        )
        exerciseList.add(pushupRotation)


        val burpees = ExerciseModel(
            4,
            "Burpees",
            R.drawable.birpie,
            false,
            false,
            "The body achieves what the mind believes.",
            "-Napoleon Hill"
        )
        exerciseList.add(burpees)


        val squats = ExerciseModel(
            5,
            "Squats",
            R.drawable.squat,
            false,
            false,
             "The hard days are the best because that’s when champions are made, so if you push through, you can push through anything.",
            "-Dana Vollmer"
        )
        exerciseList.add(squats)


        val wallSit = ExerciseModel(
            6,
            "Wall Sit",
            R.drawable.wallsit,
            false,
            false,
             "If you don’t find the time, if you don’t do the work, you don’t get the results.",
            "-Richo Wills"
        )
        exerciseList.add(wallSit)


        val lunges = ExerciseModel(
            7,
            "Lunges",
            R.drawable.lunges,
            false,
            false,
             "Dead last finish is greater than did not finish, which trumps did not start.",
            "– Arnold Schwarzenegger"
        )
        exerciseList.add(lunges)


        val plank = ExerciseModel(
            8,
            "Plank",
            R.drawable.plank,
            false,
            false,
             "Push harder than yesterday if you want a different tomorrow.",
            "-Vincent Williams Sr"
        )
        exerciseList.add(plank)




        val sidePlank = ExerciseModel(
            9,
            "Side Plank",
            R.drawable.sideplank,
            false,
            false,
            " The real workout starts when you want to stop.",
            " – Ronnie Coleman"
        )
        exerciseList.add(sidePlank)
        val tricepChairDips = ExerciseModel(
            10,
            "Tricep Chair Dips",
            R.drawable.tribichair,
            false,
            false,
            "Take care of your body. It’s the only place you have to live.",
            "― Jim Rohn"
        )
        exerciseList.add(tricepChairDips)

        val crunches = ExerciseModel(
            11,
            "Crunches",
            R.drawable.crunches,
            false,
            false,
            "I’ve failed over and over again in my life and that is why I succeed.",
            "– Michael Jordan"
        )
        exerciseList.add(crunches)

        val legRaise = ExerciseModel(
            12,
            "Leg Raise",
            R.drawable.legrise,
            false,
            false,
            "Once you are exercising regularly, the hardest thing is to stop it.",
            "― Erin Gray "
        )
        exerciseList.add(legRaise)

        return exerciseList
    }
}