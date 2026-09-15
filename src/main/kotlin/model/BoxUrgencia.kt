package org.example.model


class BoxUrgencia(codigo :String,nombre: String,tipoCliente: TipoCliente,val cirugia : Boolean): Boxs(codigo,nombre,tipoCliente)  {



    override fun tarifa(minutos : Int){
        var tarifa = 25000 * minutos / 60.0
        val iva = 1.19
        var totalPago = 0
        if (cirugia){
            tarifa *= 1.30
            totalPago = (tarifa * iva).toInt()
            println("El monto a pagar es de $tarifa")
            if (tipoCliente == TipoCliente.Fonasa){
                var totalPago2 = 0
                totalPago2 = (totalPago / 2)
                println("El monto a pagar es de $totalPago2")


            }

        }else {
            tarifa *= iva.toInt()
            println("El monto a pagar es de $tarifa")

        }

    }

}