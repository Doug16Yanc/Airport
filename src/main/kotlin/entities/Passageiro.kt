package entities


class Passageiro {
    var origem : String = ""
    var destino : String = ""
    var poltrona : Int = 0

    constructor( origem: String, destino: String, poltrona : Int)
    {
        this.origem = origem
        this.destino = destino
        this.poltrona = poltrona
    }
}