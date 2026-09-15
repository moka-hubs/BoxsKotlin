package org.example.model


class BoxGeneral (codigo :String,nombre: String,tipoCliente: TipoCliente): Boxs(codigo,nombre,tipoCliente)  {



    override fun tarifa(minutos : Int){
        var tarifa = 8000 * minutos / 60.0
        val iva = 1.19
        var totalPago = 0
        if (tipoCliente == TipoCliente.Isapre){
            tarifa *= 0.8
            totalPago = (tarifa * iva).toInt()
            println("El monto a pagar es de $totalPago")

        }else if (tipoCliente == TipoCliente.Fonasa){
            var totalPago2 = 0
            totalPago = (tarifa * iva).toInt()
            totalPago2 = (totalPago/2)
            println("El monto a pagar es de $totalPago2")
        }else {
            tarifa *= iva
            println("El monto a pagar es de $tarifa")
        }

    }

}