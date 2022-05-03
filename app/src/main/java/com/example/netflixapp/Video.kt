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
        Video(12,"land",false,R.drawable.f9),
        Video(13,"land",false,R.drawable.f9),
        Video(14,"land",false,R.drawable.f9),
        Video(15,"land",false,R.drawable.f9),
        Video(16,"land",false,R.drawable.f9),
        Video(17,"land",false,R.drawable.f9),
        Video(18,"land",false,R.drawable.f9),
        Video(19,"land",false,R.drawable.f9),
        Video(20,"land",false,R.drawable.f9),
        Video(21,"land",false,R.drawable.f9),
        Video(22,"land",false,R.drawable.f9),
        Video(23,"land",false,R.drawable.f9),
        Video(24,"land",false,R.drawable.f9),
        Video(25,"land",false,R.drawable.f9),
        Video(26,"land",false,R.drawable.f9),
        Video(27,"land",false,R.drawable.f9),
        Video(28,"land",false,R.drawable.f9),
        Video(29,"land",false,R.drawable.f9),
        Video(30,"fast & furious9",false,R.drawable.f9)

    )

    val comingSoonVideos = arrayListOf(
        Video(1,"1",false,R.drawable.dune , "coming soon"),
        Video(2,"2",false,R.drawable.dune , "coming soon"),
        Video(3,"3",false,R.drawable.dune , "coming soon"),
    )
}