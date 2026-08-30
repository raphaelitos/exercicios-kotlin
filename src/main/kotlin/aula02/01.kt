package org.example.aula02

class Produto(val nome: String, val quantidade: Int){
    var descricao: String? = null
    constructor(nome: String, quantidade: Int, descricao: String?): this(nome, quantidade){
        this.descricao = descricao ?: "Sem descrição"
    }

    override fun toString(): String {
        return "Nome: $nome\nQuantidade: $quantidade\nDescricao: $descricao"
    }
}

fun main(){
    val nome = readln()
    val quantidade = readln().toInt()
    val descricao = readlnOrNull()

    val produto = Produto(nome, quantidade, descricao)

    println(produto)
}