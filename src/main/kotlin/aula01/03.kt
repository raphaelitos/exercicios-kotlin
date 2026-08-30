package org.example.aula01
import kotlin.math.sqrt

class Ponto (val x: Float, val y: Float){
    fun distancia(other: Ponto): Float {
        val dx = this.x - other.x
        val dy = this.y - other.y
        return sqrt(dx * dx + dy * dy)
    }
}

class Circulo (val centro: Ponto, val raio: Float){
    fun colidiu(other: Circulo): Boolean{
        return (this.centro.distancia(other.centro) > (this.raio + other.raio))
    }
}

fun main(){
    val circ1: List<Float> = readln().split(" ").map { it.toFloat() }
    val circ2: List<Float> = readln().split(" "). map{ it.toFloat() }

    val p1 = Ponto(circ1[0], circ1[1])
    val p2 = Ponto(circ2[0], circ2[1])

    val c1 = Circulo(p1, circ1[2])
    val c2 = Circulo(p2, circ2[2])

    if(c1.colidiu(c2)) print("ACERTOU") else print("ERROU")
}