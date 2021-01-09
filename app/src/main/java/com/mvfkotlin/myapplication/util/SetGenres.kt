package com.mvfkotlin.myapplication.util

import timber.log.Timber
import java.lang.StringBuilder

fun setGenres(genreList: List<Int>): String{
    val hashMap = hashMapOf<Int, String>()
    fillHashMap(hashMap)
    val a = StringBuilder()

    for(item in genreList){
        for(genreItem in hashMap){
            if(item == genreItem.key){
                a.append(genreItem.value + ", ")
            }
        }
    }
    a.deleteAt(a.length - 1)
    a.deleteAt(a.length - 1)

    return a.toString()
}

private const val moviesAction = 28
private const val moviesAdventure = 12
private const val moviesAnimation = 16
private const val moviesComedy = 35
private const val moviesCrime = 80
private const val moviesDocumentary = 99
private const val moviesDrama = 18
private const val moviesFamily = 10751
private const val moviesFantasy = 14
private const val moviesHistory = 36
private const val moviesHorror = 27
private const val moviesMusic = 10402
private const val moviesMystery = 9648
private const val moviesRomance = 10749
private const val moviesScienceFiction = 878
private const val moviesTVMovie = 10770
private const val moviesThriller = 53
private const val moviesWar = 10752
private const val moviesWestern = 37
private const val ActionAdventure = 10759
private const val Kids = 10762
private const val News = 10763
private const val Reality = 10764
private const val SciFiFantasy = 10765
private const val Soap = 10766
private const val Talk = 10767
private const val WarPolitics = 10768

private fun fillHashMap(genresHashMap: HashMap<Int, String>) {
    genresHashMap[ActionAdventure] = "Action Adventure"
    genresHashMap[Kids] = "Kids"
    genresHashMap[News] = "News"
    genresHashMap[Reality] = "Reality"
    genresHashMap[SciFiFantasy] = "Sci-Fi & Fantasy"
    genresHashMap[Soap] = "Soap"
    genresHashMap[Talk] = "Talk"
    genresHashMap[WarPolitics] = "War & Politics"
    genresHashMap[moviesAction] = "Action"
    genresHashMap[moviesAdventure] = "Adventure"
    genresHashMap[moviesAnimation] = "Animation"
    genresHashMap[moviesComedy] = "Comedy"
    genresHashMap[moviesCrime] = "Crime"
    genresHashMap[moviesDocumentary] = "Documentary"
    genresHashMap[moviesDrama] = "Drama"
    genresHashMap[moviesFamily] = "Family"
    genresHashMap[moviesHistory] = "History"
    genresHashMap[moviesHorror] = "Horror"
    genresHashMap[moviesMusic] = "Music"
    genresHashMap[moviesMystery] = "Mystery"
    genresHashMap[moviesRomance] = "Romance"
    genresHashMap[moviesScienceFiction] = "Science Fiction"
    genresHashMap[moviesTVMovie] = "TV Movie"
    genresHashMap[moviesThriller] = "Thriller"
    genresHashMap[moviesWar] = "War"
    genresHashMap[moviesWestern] = "Western"
    genresHashMap[moviesFantasy] = "Fantasy"
}
