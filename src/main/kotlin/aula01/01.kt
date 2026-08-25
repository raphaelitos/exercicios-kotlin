package org.example.aula01

fun main(){
    val linhas: Int = readln().toInt()
    var b: Int = 1

    for(i in 1..linhas) {
        for(j in 1..i) {
            print("${b++} ")
        }
        println("")
    }
}