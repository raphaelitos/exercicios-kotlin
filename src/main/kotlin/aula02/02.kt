package org.example.aula02

fun main(){
    val k: Int = readln().toInt()
    val palavras: List<String> = readln().lowercase().split(" ")
    val frequencias: Map<String, Int> = palavras.groupingBy {it}.eachCount()
    val fatia = frequencias.entries.sortedByDescending { it.value }.take(k)


    fatia.forEach { (str, freq) ->
        println("$str: $freq")
    }
}