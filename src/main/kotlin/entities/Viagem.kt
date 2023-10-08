package entities


open class Viagem {
    var id : Int = 0
    var poltrona : Int = 0
    constructor(){
    }
    constructor(id : Int, poltrona : Int){
        this.id = id
        this.poltrona = poltrona
    }
}