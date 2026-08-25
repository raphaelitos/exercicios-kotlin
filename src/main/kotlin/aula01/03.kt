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
        return (distancia(this.centro, other.centro) > (this.raio + other.raio))
    }
}

fun main(){
    x1, y1, r1 = readln().ToFloat.Split()
    x2, y2, r2 = readln().ToFloat.Split()

    p1 = Ponto(x1, y1)
    p2 = Ponto(x2, y2)

    c1 = Circulo(p1, r1)
    c2 = Circulo(p2, r2)

    if(c1.colidiu(c2)) print("ACERTOU") else print("ERROU")
}