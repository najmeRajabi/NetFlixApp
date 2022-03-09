package com.example.netflixapp

data class  Video(val name: String , var isFave:Boolean , val image:Int) {
}
object Videos{
    val videos = arrayListOf<Video>(
        Video("2021",false,R.drawable.f9),
        Video("Crisis",false,R.drawable.f9),
        Video("Dune",true,R.drawable.f9),
        Video("Lamb",false,R.drawable.f9),
        Video("Masquerade",false,R.drawable.f9),
        Video("Oxygen",true,R.drawable.f9),
        Video("Reminiscence",false,R.drawable.f9),
        Video("Settlers",false,R.drawable.f9),
        Video("The Colony",false,R.drawable.f9),
        Video("Warning",false,R.drawable.f9),
        Video("fast & furious9",true,R.drawable.f9),
        Video("land",false,R.drawable.f9)

    )

}