class Condominio(val qtdAreasComum: Int, val qtdMoradores: Int)

// área comum: possui um nome, identificador único, capacidade máxima;
class AreaComum(val nome: String, val id: String, val capaciade){};

// morador: possui o nome, identificador único (CPF), data de nascimento e identificador da residência (ex: 304A);
class Morador(val nome: String, val id: String, val dataNasc: Date, idCasa: String){};

// reserva: possui o morador que realizou a reserva, a área reservada, a data da reserva e a quantidade de convidados
class Reserva(val dono: Morador, val area: Float, data: Date, val qtdConvidados: Int){};

/*
* As reservas devem seguir as seguintes regras:

    Para realizar uma reserva, é necessário informar o identificador único da área, o CPF do morador, a data da reserva e a quantidade de convidados;
    Apenas moradores cadastrados podem realizar reservas;
    Uma área comum só pode ser reservada por moradores maiores de idade (maior ou igual a 18 anos) considerando como referência a data da reserva;
    A quantidade de convidados deve ser menor ou igual do que a capacidade máxima da área;
    Um morador só pode ter uma reserva por dia, mesmo que o condomínio disponha de múltiplas áreas;
    Uma área só pode ter uma reserva por dia;
    As reservas são realizadas por ordem de chegada. Quem pediu primeiro, se cumprir todas as regras, tem a reserva;
    Se a solicitação de reserva descumprir qualquer um dos requisitos descritos, ela não será realizada, isto é, não haverá impressão da lista de reserva.

* */


/*
* Ler da entrada padrão:

    Um inteiro com a quantidade de áreas comuns, seguido das informações desta(s) área(s).
    Um inteiro com a quantidade de moradores, seguido das informações deste(s) morador(es).
    Um R que indica uma nova reserva, seguido das informações desta(s) reserva(es).
    * A lista reservas terá um valor inicial e capacidade da lista deve ser aumentada de acordo com a necessidade.


* */