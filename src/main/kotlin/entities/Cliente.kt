package entities

import java.util.*

open class Cliente {
    var id: UUID
    var nome : String = ""
    var cpf : Long = 0
    var rg : Long = 0

    constructor(id: UUID, nome: String, cpf: Long, rg: Long){
        this.id = id
        this.nome = nome
        this.cpf = cpf
        this.rg = rg
    }

    override fun toString(): String {
        return "Dados do cliente:\n" +
                "ID do cliente: $id\n" +
                "Nome: $nome\n" +
                "Cadastro de pessoa física (CPF): $cpf\n" +
                "Número de registro geral (RG): $rg\n"
    }

}