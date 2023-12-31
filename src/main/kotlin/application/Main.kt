package application

import entities.*
import java.lang.System.exit
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random


val poltronas: Int = 10
val sc = Scanner(System.`in`)
val list1 : MutableList<Cliente> = ArrayList()
val list2 : MutableList<Passageiro> = ArrayList()
val econ = Array(poltronas) {false}
val exec = Array(poltronas) {false}
val cliente = Cliente()
val passageiro = Passageiro()

fun main(){
    do{
        println("******************************************************\n")
        println("Bem-vindo(a) ao sistema de vendas de passagens aéreas\n")
        println("Por favor, selecione uma alternativa:\n")
        println("  |    1 - Cadastrar dados de cliente:        | \n")
        println("  |    2 - Vender passagem:                    | \n")
        println("  |    3 - Visualizar ocupações no avião:     | \n")
        println("  |    4 - Encerrar aplicação                 | \n")
        println("******************************************************\n")

        var opcao = sc.nextInt()

        when(opcao){
            1 -> cadastrarCliente(list1, sc)
            2 -> venderPassagem(list1, list2, sc)
            3 -> visualizarOcupacao()
            4 -> encerrarPrograma()
            else -> println("Opção impossível.\n")
        }

    }
    while (true)

}


fun gerarID(cliente: List<Cliente>): Int {
    var num = 0

    var entrada = Random.nextInt(100000, 1000000)
    var aux = true

    while (entrada != 1) {
        for (i in 0 until cliente.size) {
            if (entrada == cliente[i].id) {
                aux = false
            }
        }

        if (aux) {
            return entrada
        } else {
            entrada = Random.nextInt(100000, 1000000)
        }
    }

    return entrada
}

fun cadastrarCliente(list1: MutableList<Cliente>, sc: java.util.Scanner) {
    println("Solicitando operação para realizar cadastro de cliente:\n")

    println("Nome do cliente: ")
    val nome = sc.next()

    sc.nextLine()

    println("CPF do cliente: ")
    val cpf = sc.nextLong()

    println("RG do cliente:")
    val rg = sc.nextLong()

    val id = gerarID(list1)
    val cliente = Cliente(id, nome, cpf, rg)

    println("Id do cliente: ${cliente.id}\n")

    println(cliente)

    list1.add(cliente)
}

private fun venderPassagem(list1: MutableList<Cliente>, list2: MutableList<Passageiro>, sc: java.util.Scanner){
    println("Solicitando operação para vender passagem:\n")

    println("Informe o CPF do cliente:")
    var CPF = sc.nextLong()

    val clienteEncontrado = list1.find { it.cpf == CPF }

    if (clienteEncontrado != null) {
        println("Cliente encontrado no sistema de gerenciamento com sucesso.\n")

        sc.nextLine()

        println("Origem do passageiro: ")
        var origem = sc.nextLine()

        println("Destino do passageiro: ")
        var destino = sc.nextLine()

        println("Digite a escolha do passageiro:\n" +
                "1 - Classe econômica:\n" +
                "2 - Classe executiva:\n")
        var escolha = sc.nextInt()

        when(escolha){
            1 -> escolherEconomica(econ, cliente, passageiro)
            2 -> escolherExecutiva(exec, cliente, passageiro)
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

    println("Distribuição de poltronas na classe econômica:\n")
    for (i in econ.indices){
        val estado = if (econ[i]) " \u001B[41m - Ocupado \u001B[0m\n"  else "\u001B[42m - Livre \u001B[0m\n"
        println("${i + 1}$estado")
    }
    println("\n")
    println("Distribuição de poltronas na classe executiva:\n")
    for (i in exec.indices){
        val estado1 = if (exec[i]) " \u001B[41m - Ocupado \u001B[0m\n"  else "\u001B[42m - Livre \u001B[0m\n"
        println("${i + 1}$estado1")
    }
    println("\n")

}

private fun escolherEconomica(econ: Array<Boolean>, cliente : Cliente, passageiro: Passageiro){

    println("Distribuição de poltronas:\n")

    for (i in econ.indices){
        val estado = if (econ[i]) " \u001B[41m - Ocupado \u001B[0m\n"  else "\u001B[42m - Livre \u001B[0m\n"
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
            gerarPassagemEconomica(list1, list2, escolha)
        }
    }
    else{
        println("Número de poltrona não disponível.\n")
    }

}

fun gerarPassagemEconomica(list1: MutableList<Cliente>, list2: MutableList<Passageiro>, escolha : Int) {
    println("*******************Passagem***********************\n")
    println("Nome do passageiro: ${cliente.nome}\n" +
            "Cadastro de pessoa física: ${cliente.cpf}\n" +
            "Registro geral: ${cliente.rg}\n" +
            "ID : ${cliente.id}\n" +
            "Origem : ${passageiro.origem}\n" +
            "Destino : ${passageiro.destino}\n" +
            "Número de poltrona : ${escolha}\n" +
            "Id da viagem :n")
    println("************************************************\n")
    fornecerDicas()

}

private fun escolherExecutiva(exec: Array<Boolean>, cliente: Cliente, passageiro: Passageiro) {
    println("Distribuição de poltronas:\n")

    for (i in exec.indices){
        val estado = if (exec[i]) " \u001B[41m - Ocupado \u001B[0m\n"  else "\u001B[42m - Livre \u001B[0m\n"
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

            gerarPassagemExecutiva(list1, list2, escolha)
        }
    }
    else{
        println("Número de poltrona não disponível.\n")
    }
}

private fun gerarPassagemExecutiva(list1: MutableList<Cliente>, list2: MutableList<Passageiro>, escolha : Int) {
    println("*******************Passagem***********************\n")
    println("Nome do passageiro: ${cliente.nome}\n" +
            "Cadastro de pessoa física: ${cliente.cpf}\n" +
            "Registro geral: ${cliente.rg}\n" +
            "ID : ${cliente.id}\n" +
            "Origem : ${passageiro.origem}\n" +
            "Destino : ${passageiro.destino}\n" +
            "Número de poltrona : ${escolha}\n" +
            "Id da viagem :\n")
    println("************************************************\n")
    fornecerDicas()

}

private fun fornecerDicas(){
    println("\n********Dicas de segurança para sua viagem**********")
    println(" 1 - Guarde seus pertences com sabedoria    \n" +
            " 2 - Atenção com sua bagagem   \n" +
            " 3 - Não confie em estranhos   \n" +
            " 4 - Tenha cópia de documentos importantes \n" +
            " 5 - Tenha disponibilidade de redes móveis ou dados de chip local \n" +
            " 6 - Faça um seguro viagem \n ")
    println("Faça uma feliz e tranquila viagem!")
    println("******************************************************\n")


}
