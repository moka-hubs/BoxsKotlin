package org.example.model

sealed class TipoCliente {
    object Isapre : TipoCliente()
    object Fonasa : TipoCliente()
    object Particular : TipoCliente()
}