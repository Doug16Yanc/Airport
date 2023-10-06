package entities

import java.util.*

class Viagem (val id : UUID, poltrona : Int) {
    constructor() : this(UUID.randomUUID(), 0)
}