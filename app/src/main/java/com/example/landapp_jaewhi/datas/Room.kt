package com.example.landapp_jaewhi.datas

import java.io.Serializable
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class Room(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String

    ) : Serializable {

    fun getFormattedPrice () : String {

        if (this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000

            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}만원"
        }
        else{
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}만"
        }

    }

    fun getFormattedFloor() : String {

        if(this.floor > 0){
            return ", ${this.floor}층"
        }
        else if (this.floor == 0){
            return ", 반지하"
        }
        else{
            return ", 지하${-this.floor}층"
        }

    }

}