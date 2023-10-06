package entities

import java.util.*

import java.util.UUID

open class Cliente(val id: UUID, var nome: String, var cpf: Long, var rg: Long) {

   constructor() : this(UUID.randomUUID(), "", 0, 0)


    override fun toString(): String {
        return "Dados do cliente:\n" +
                "ID do cliente: $id\n" +
                "Nome: $nome\n" +
                "Cadastro de pessoa física (CPF): $cpf\n" +
                "Número de registro geral (RG): $rg\n"
    }

}