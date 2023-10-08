package entities


class Passageiro{
    var origem : String = ""
    var destino : String = ""

    constructor(){

    }
    constructor(origem : String, destino : String){
        this.origem = origem
        this.destino = destino
    }

    override fun toString(): String {
        return "\nOrigem: $origem'" +
                "\ndestino: $destino')"
    }

}