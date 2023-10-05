package entities

class Passageiro  {
    var id: Long = 0
    var nome : String = ""
    var cpf : String = ""
    var rg : String = ""
    var origem : String = ""
    var destino : String = ""

    constructor(id : Long, nome : String, cpf : String, rg : String, origem : String, destino : String){
        this.id = id
        this.nome = nome
        this.cpf = cpf
        this.rg = rg
        this.origem = origem
        this.destino = destino
    }
}