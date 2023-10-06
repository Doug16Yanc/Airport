package entities

open class Cliente {
    var id: Long = 1
    var nome : String = ""
    var cpf : String = ""
    var rg : String = ""

    constructor(id: Long, nome: String, cpf: String, rg: String){
        this.id = id
        this.nome = nome
        this.cpf = cpf
        this.rg = rg
    }

    override fun toString(): String {
        return "Dados do cliente:\n" +
                "ID do cliente: '$id'," +
                "Nome: '$nome'," +
                "Cadastro de pessoa física (CPF): '$cpf', " +
                "Número de registro geral (RG): '$rg'"
    }

}