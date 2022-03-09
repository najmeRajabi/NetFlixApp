package com.example.netflixapp

data class  Video(val name: String , var isFave:Boolean , val image:Int) {
}
object Videos{
    val videos = arrayListOf<Video>(
        Video("2021",false,R.drawable.film2021),
        Video("Crisis",false,R.drawable.crisis),
        Video("Dune",true,R.drawable.dune),
        Video("Lamb",false,R.drawable.lamb),
        Video("Masquerade",false,R.drawable.masquerade),
        Video("Oxygen",true,R.drawable.oxygen),
        Video("Reminiscence",false,R.drawable.reminiscence),
        Video("Settlers",false,R.drawable.settlers),
        Video("The Colony",false,R.drawable.colony),
        Video("Warning",false,R.drawable.warning),
        Video("fast & furious9",true,R.drawable.f9),
        Video("land",false,R.drawable.land)

    )
}