package com.selcanasirova.newscatcher.data

import com.selcanasirova.newscatcher.R

enum class MainNewsData (
    val img: Int,
    val news: String,
    val details: String,
    val date: String,
    val nameWriter: String,
    val btn: String
){
    News1(R.drawable.newsimg,"New Music Releases March 25: Ed Sheeran, J Balvin, Maren... ","Factbox: Who is still buying Russian crude oil?","Jennifer Wars","2022-03-26","Finance"),
    News2(R.drawable.download,"New Music Releases March 25: Ed Sheeran, J Balvin, Maren... ","Factbox: Who is still buying Russian crude oil?","Jennifer Wars","2022-03-26","Finance"),
    News3(R.drawable.newsimg,"New Music Releases March 25: Ed Sheeran, J Balvin, Maren... ","Factbox: Who is still buying Russian crude oil?","Jennifer Wars","2022-03-26","Finance"),
//    News4(R.drawable.download,"New Music Releases March 25: Ed Sheeran, J Balvin, Maren... ","Factbox: Who is still buying Russian crude oil?","Jennifer Wars","2022-03-26","Finance")
}

enum class Lang(
    val language: String
){
    Lang1("EN"),
    Lang2("RU")
}
