package org.example.aula03
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

// Atalho para formatar qualquer data no padrão brasileiro
val LocalDate.formatada: String
    get() = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

fun parseDate(dateStr: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return try {
        LocalDate.parse(dateStr, formatter)
    } catch (e: DateTimeParseException) {
        throw  IllegalArgumentException("Data de nascimento invalida", e)
    }
}

// área comum: possui um nome, identificador único, capacidade máxima;
class AreaComum(val nome: String, val id: String, val capacidade: Int){
    override fun toString(): String = buildString {
        appendLine("Nome: $nome")
        appendLine("Id: $id")
        appendLine("Capacidade: $capacidade")
    }
};

// morador: possui o nome, identificador único (CPF), data de nascimento e identificador da residência (ex: 304A);
class Morador(val nome: String, val cpf: String, val dataNasc: LocalDate, val idCasa: String){
    override fun toString(): String = buildString {
        appendLine("Nome: $nome")
        appendLine("CPF: $cpf")
        appendLine("Data de Nascimento: ${dataNasc.formatada}")
        appendLine("Residência: $idCasa")
    }
};

// reserva: possui o morador que realizou a reserva, a área reservada, a data da reserva e a quantidade de convidados
class Reserva(val dono: Morador, val areaReservada: AreaComum, val data: LocalDate, val qtdConvidados: Int){
    override fun toString(): String = buildString {
        appendLine("--------- RESERVA ----------- ")
        appendLine("Morador:")
        append(dono.toString())
        appendLine("")
        appendLine("Area reservada:")
        append(areaReservada.toString())
        appendLine("Data da reserva: ${data.formatada}")
        appendLine("")

        appendLine("Quantidade de convidados: $qtdConvidados")

        val taxaOcupacao = (qtdConvidados.toDouble() / areaReservada.capacidade) * 100
        appendLine("Taxa de ocupação: ${String.format("%.2f", taxaOcupacao)}%")
        appendLine("------------------------------")
    }
};

class Condominio(){
    var areas = mutableListOf<AreaComum>()
    var moradores = mutableListOf<Morador>()
    var reservas = mutableListOf<Reserva>()

    fun processaEntrada(){
        val qtdAreasComum: Int = readln().toInt()
        for(i in 0 until qtdAreasComum){
            val nome: String = readln()
            val id: String = readln()
            val capaciade: Int = readln().toInt()

            areas.add(AreaComum(nome, id, capaciade))
        }

        val qtdMoradores: Int = readln().toInt()
        for(i in 0 until qtdMoradores){
            val nome: String = readln()
            val cpf: String = readln()
            val dataNasc = parseDate(readln())
            val idCasa: String = readln()

            moradores.add(Morador(nome, cpf, dataNasc, idCasa))
        }

        while(readln() != "F"){
            val idArea: String = readln()
            val cpfReservista: String = readln()
            val dataReserva: LocalDate = parseDate(readln())
            val qtdConvidados: Int = readln().toInt()

            val areaComumReserva = areas.find { it.id == idArea }
            val morador = moradores.find {it.cpf == cpfReservista}

            if(areaComumReserva == null){
                throw Exception("Reserva invalida! Area comum nao encontrada")
            }
            if(morador == null){
                throw Exception("Reserva invalida! CPF nao cadastrado")
            }
            if(dataReserva.isBefore(morador.dataNasc.plusYears(18))){
                throw Exception("Reserva invalida! Morador nao possui maioridade")
            }
            if(qtdConvidados > areaComumReserva.capacidade){
                throw Exception("Reserva Invalida! Qtd de convidados excede a capacidade da area")
            }
            if(reservas.any {it.areaReservada.id == idArea && it.data == dataReserva}){
                throw Exception("Reserva Invalida! Area ja reservada nessa data")
            }
            if(reservas.any {it.dono.cpf == cpfReservista && it.data == dataReserva}){
                throw Exception("Reserva Invalida! Morador ja tem reserva nessa data")
            }

            reservas.add(Reserva(morador, areaComumReserva, dataReserva, qtdConvidados))
        }
    }

    fun imprimeReservas(){
        reservas.forEach { println(it.toString()) }
    }
}

fun main(){
    val condo = Condominio()
    condo.processaEntrada()
    condo.imprimeReservas()
}