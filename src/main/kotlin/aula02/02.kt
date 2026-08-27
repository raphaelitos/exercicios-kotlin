fun main(){
    val palavras: = readln().split(" ")
    val frequencias: = palavras.groupingBy {it}.eachCount()

    println(frequencias[0].value)
}