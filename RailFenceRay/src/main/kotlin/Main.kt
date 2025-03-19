package org.example
import javax.swing.JOptionPane


fun cifrar(mensaje: String) : ArrayList<Char> {
    var contador = 0
    var salto = 0
    var aux = 0
    var inicio = false
    var mensajeCifrado = ArrayList<Char>()

    while (true){

        for ((index, letra) in mensaje.withIndex()) {

            println("Contador es $contador")

            println("El index es $index")
            println("La letra es: $letra")
            println("El aux ess: $aux")



            if (contador == 0 || contador == 2){
                salto = 3
            }else if (contador == 1){
                salto = 1

            }

            if (index != contador && inicio == false){
                println("Continuando")
                continue
            }else{
                println("No continuando")
                inicio = true
            }



            if (aux==salto || index == contador){
                mensajeCifrado.add(letra)
                aux=0
                println("Se agrego")
            }else{
                aux += 1
            }

            println("-------------------")

        }
        aux = 0
        inicio = false



        if (contador == 2){
            break;
        }

        contador += 1

    }

    return mensajeCifrado


}

fun descifrar(mensaje: String): ArrayList<Char> {
    val mensajeDescifrado = ArrayList<Char>(mensaje.length) // Inicializamos el ArrayList con el tamaño necesario

    // Llenamos el ArrayList con espacios vacíos (o cualquier valor inicial)
    for (i in 0 until mensaje.length) {
        mensajeDescifrado.add(' ')
    }

    var contador = 0
    var aux = 0
    var inicio = false
    var salto = 0
    var indiceDescifrado = 0

    while (true) {
        for ((index, _) in mensaje.withIndex()) {
            // Determinamos el valor de salto según el contador
            if (contador == 0 || contador == 2) {
                salto = 3
            } else if (contador == 1) {
                salto = 1
            }

            // Controlamos el flujo para iniciar el descifrado
            if (index != contador && !inicio) {
                continue
            } else {
                inicio = true
            }

            // Si el índice es el correcto, desciframos el mensaje
            if (aux == salto || index == contador) {
                mensajeDescifrado[index] = mensaje[indiceDescifrado]
                indiceDescifrado++
                aux = 0
            } else {
                aux += 1
            }
        }

        aux = 0
        inicio = false

        if (contador == 2) {
            break
        }

        contador += 1
    }

    return mensajeDescifrado
}

fun main() {

    val opcion = JOptionPane.showInputDialog("1 para cifrar o 2 para descifrar")

    if (opcion == null){
        println("Opcion is null")
        return
    }else if (opcion == "1"){
        val mensaje = JOptionPane.showInputDialog("Introduce el mensaje a cifrar:")

        if (mensaje != null) {
            val mensajeCifrado: ArrayList<Char> = cifrar(mensaje)
            JOptionPane.showMessageDialog(null, "El mensaje cifrado es: $mensajeCifrado")
        }

    }else if (opcion == "2"){

        val mensaje = JOptionPane.showInputDialog("Introduce el mensaje a descifrar:")

        if (mensaje != null) {
            val mensajeDecifrado: ArrayList<Char> = descifrar(mensaje)
            JOptionPane.showMessageDialog(null, "El mensaje cifrado es: $mensajeDecifrado")
        }


    }










}