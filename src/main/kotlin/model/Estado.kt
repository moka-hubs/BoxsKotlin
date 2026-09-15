package org.example.model

sealed class Estado {
    object Libre : Estado()
    object Ocupado : Estado()
    object EnProceso : Estado()
    object FueraServicio : Estado()


    data class Boxes(
        var codigo: Int,
        var boxes: Boxs? = null,
        var estado: Estado = Estado.Libre
    )

}