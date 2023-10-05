package application

import java.util.*


val sc = Scanner(System.`in`)

fun main(){

    val poltronas = 10
    val econ = Array(poltronas) {false}

    do{
        println("******************************************************\n")
        println("Bem-vindo(a) ao sistema de vendas de passagens aéreas\n")
        println("Por favor, selecione uma alternativa:\n")
        println("       1 - Classe econômica:         \n")
        println("       2 - Classe executiva:         \n")
        println("       3 - Encerrar programa:        \n")
        println("******************************************************\n")

        var opcao = sc.nextInt()

        when(opcao){
            1 -> escolherEconomica(econ)
            2 -> escolherExecutiva()
            3 -> println("Foi um prazer atendê-lo, tenha um ótimo dia ou ótima noite.\n")
            else -> println("Opção impossível.\n")
        }

    }
    while (true)

}

private fun escolherEconomica(econ: Array<Boolean>){

    println("Distribuição de poltronas:\n")

    for (i in econ.indices){
        val estado = if (econ[i]) " \u001B[42m - Ocupado \u001B[0m\n"  else "\u001B[41m - Livre \u001B[0m\n"
        println("${i + 1}$estado")
    }

    println("Escolha um nÃºmero de poltrona:\n")
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

private fun escolherExecutiva(){

}
