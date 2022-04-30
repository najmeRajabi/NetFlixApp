package com.example.netflixapp

data class  Video(val id:Int , val name: String , var isFave:Boolean , val image:Int , val description:String?=null) {
}
object Videos{
    val videos = arrayListOf<Video>(
        Video(1,"2021",false,R.drawable.f9),
        Video(2,"Crisis",false,R.drawable.f9),
        Video(3,"Dune",false,R.drawable.f9),
        Video(4,"Lamb",false,R.drawable.f9),
        Video(5,"Masquerade",false,R.drawable.f9),
        Video(6,"Oxygen",false,R.drawable.f9),
        Video(7,"Reminiscence",false,R.drawable.f9),
        Video(8,"Settlers",false,R.drawable.f9),
        Video(9,"The Colony",false,R.drawable.f9),
        Video(10,"Warning",false,R.drawable.f9),
        Video(11,"fast & furious9",false,R.drawable.f9),
        Video(12,"land",false,R.drawable.f9)

    )

    val comingSoonVideos = arrayListOf(
        Video(1,"1",false,R.drawable.dune , "coming soon"),
        Video(2,"2",false,R.drawable.dune , "coming soon"),
        Video(3,"3",false,R.drawable.dune , "coming soon"),
    )
}