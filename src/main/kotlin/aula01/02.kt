package org.example.aula01

fun ehSenhaValida(senha: String) : Boolean {
    if (senha.length != 8) return false
    if (!(senha.any { it.isUpperCase() } && senha.any { it.isDigit() })) return false
    return true
}

fun main(){
    val senha = readln()
    if(ehSenhaValida(senha)) println("SENHA VALIDA") else println("SENHA INVALIDA")
}