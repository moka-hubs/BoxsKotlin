package org.example

import org.example.model.BoxEspecialidad
import org.example.model.BoxGeneral
import org.example.model.BoxUrgencia
import org.example.model.TipoCliente
import kotlinx.coroutines.coroutineScope
import org.example.service.Funciones

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() = coroutineScope () {
    val gestor = Funciones()

    val box1 = BoxGeneral("RN12PA","Juan Perez", TipoCliente.Isapre)
    val box2 = BoxGeneral("RN99ZA","Maria Lopez", TipoCliente.Particular)
    val box3 = BoxEspecialidad("RN12PA","Juan Perez", TipoCliente.Particular)
    val box4 = BoxUrgencia("RN44RG","Ana Torres", TipoCliente.Fonasa,false)
    val box5 = BoxUrgencia("RN77RG","Luis Soto", TipoCliente.Particular,false)

    try {
        gestor.registrarIngreso(box3)
        gestor.registrarIngreso(box5)
        gestor.registrarSalida(2, 45)
        gestor.registrarIngreso(box5)
        gestor.registrarSalida(100, 45)
        gestor.registrarSalida(1, 45)
    }
    catch (e: Exception) {
        println(e)
    }


}