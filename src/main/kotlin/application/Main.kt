package application

import entities.*
import java.lang.System.exit
import java.util.*
import kotlin.collections.ArrayList


val poltronas: Int = 0
val sc = Scanner(System.`in`)
val list1 : MutableList<Cliente> = ArrayList()
val list2 : MutableList<Passageiro> = ArrayList()
val econ = Array(poltronas) {false}
val exec = Array(poltronas) {false}

fun main(args: Array<String>){
    executaInteracao()
}


private fun executaInteracao(){

    val poltronas = 10

    do{
        println("******************************************************\n")
        println("Bem-vindo(a) ao sistema de vendas de passagens aéreas\n")
        println("Por favor, selecione uma alternativa:\n")
        println("  |     1 - Cadastrar dados de cliente:        | \n")
        println("  |    2 - Vender passagem:                    | \n")
        println("  |     3 - Visualizar ocupações no avião:     | \n")
        println("  |     4 - Encerrar aplicação                 | \n")
        println("******************************************************\n")

        var opcao = sc.nextInt()

        when(opcao){
            1 -> cadastrarCliente()
            2 -> venderPassagem()
            3 -> visualizarOcupacao()
            4 -> encerrarPrograma()
            else -> println("Opção impossível.\n")
        }

    }
    while (true)

}

fun gerarID() : UUID{
    return UUID.randomUUID()
}
private fun cadastrarCliente(){
    println("Solicitando operação para realizar cadastro de cliente:\n")

    println("Nome do cliente: ")
    var nome = sc.next()

    sc.nextLine()

    println("CPF do cliente: ")
    var cpf = sc.nextLong()

    println("RG do cliente:")
    var rg = sc.nextLong()

    var clienteID = gerarID()
    println("Id do cliente: ${clienteID}")

    val cliente = Cliente(clienteID, nome, cpf, rg)

    list1.add(cliente)

}

private fun venderPassagem(){
    println("Solicitando operação para vender passagem:\n")

    println("Informe o CPF do cliente:")
    var CPF = sc.nextLong()

    val clienteEncontrado = list1.find { it.cpf == CPF }

    if (clienteEncontrado != null) {
        println("Cliente encontrado no sistema de gerenciamento com sucesso.\n")

        println("Origem do passageiro: ")
        var origem = sc.nextLine()

        println("Destino do passageiro: ")
        var destino = sc.nextLine()

        println("Digite a escolha do passageiro:\n" +
                "1 - Classe econômica:\n" +
                "2 - Classe executiva:\n")
        var escolha = sc.nextInt()

        when(escolha){
            1 -> escolherEconomica(econ)
            2 -> escolherExecutiva(exec)
        }

        val passageiro = Passageiro( origem, destino)

        list2.add(passageiro)

    }
    else {
        println("Cliente não encontrado, portanto, não foi possível realizar operação a fim de vender passagem. Realize antes o cadastro de cliente.\n")
    }
}

private fun encerrarPrograma(){
    println("Foi um prazer atendê-lo, tenha um ótimo dia ou ótima noite.\n")
    exit(0)
}

private fun visualizarOcupacao(){

}

private fun escolherEconomica(econ: Array<Boolean>){

    println("Distribuição de poltronas:\n")

    for (i in econ.indices){
        val estado = if (econ[i]) " \u001B[42m - Ocupado \u001B[0m\n"  else "\u001B[41m - Livre \u001B[0m\n"
        println("${i + 1}$estado")
    }

    println("Escolha um número de poltrona:\n")
    var escolha = sc.nextInt()

    if (escolha >= 1 && escolha <= econ.size){
        if (econ[escolha - 1]){
            println("Poltrona já ocupada.\n")
        }
        else{
            println("Poltrona ${escolha} ocupada com sucesso.\n")
            econ[escolha - 1] = true
        }
    }
    else{
        println("Número de poltrona não disponível.\n")
    }
}

private fun escolherExecutiva(exec: Array<Boolean>) {
    println("Distribuição de poltronas:\n")

    for (i in exec.indices){
        val estado = if (exec[i]) " \u001B[42m - Ocupado \u001B[0m\n"  else "\u001B[41m - Livre \u001B[0m\n"
        println("${i + 1}$estado")
    }

    println("Escolha um número de poltrona:\n")
    var escolha = sc.nextInt()

    if (escolha >= 1 && escolha <= exec.size){
        if (exec[escolha - 1]){
            println("Poltrona já ocupada.\n")
        }
        else{
            println("Poltrona ${escolha} ocupada com sucesso.\n")
            exec[escolha - 1] = true
        }
    }
    else{
        println("Número de poltrona não disponível.\n")
    }
}
