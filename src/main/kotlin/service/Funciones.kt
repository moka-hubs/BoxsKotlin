package org.example.service

import org.example.model.Boxs
import org.example.model.Estado
import kotlinx.coroutines.delay

class Funciones {

    val capacidad = 10
    val listaBoxes = MutableList(capacidad) { i ->
        Estado.Boxes(
            codigo = i + 1,
            boxes = null,
            estado = Estado.Libre
        )
    }


    suspend fun registrarIngreso(boxs : Boxs){
        println("Intento de registrar ingreso del boxs ${boxs.codigo}")

        var boxLibre = listaBoxes.find { it.estado == Estado.Libre }

        if (boxLibre == null) {
            println("[ERROR] No hay boxes disponibles.")
            return
        }
        boxLibre.estado = Estado.EnProceso

        delay(1000)

        boxLibre.estado = Estado.Ocupado
        boxLibre.boxes = boxs

        println("Boxs ${boxs.codigo} registrado satisfactoriamente")

    }

    suspend fun registrarSalida(codigo: Int, minutos: Int){
        println("Intento de registrar salida boxs codigo $codigo")

        var boxsQueSale = listaBoxes.find { it.codigo == codigo }

        if (boxsQueSale == null) {
            println("[ERROR] No existe un boxs  con ese codigo.")
            return
        }

        boxsQueSale.estado = Estado.EnProceso

        delay(3000)

        boxsQueSale.estado = Estado.Libre
        boxsQueSale.boxes?.tarifa(minutos)
        boxsQueSale.boxes = null


        println("Codigo ${codigo} salió satisfactoriamente")

    }



}