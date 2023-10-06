package entities

class Passageiro : Cliente {
    var origem : String = ""
    var destino : String = ""

    constructor(id : Long, nome : String, cpf : String, rg : String, origem : String, destino : String):
    super(id, nome, cpf, rg)
    {
        this.origem = origem
        this.destino = destino
    }
}