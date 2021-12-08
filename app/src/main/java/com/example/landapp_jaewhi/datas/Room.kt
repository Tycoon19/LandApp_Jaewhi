package com.example.landapp_jaewhi.datas

import java.io.Serializable
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

//  데이터클래스 생성. 객체화시키기 위해 생성자를 만든다. 클래스 = 개념, 개념을 실체화하기 위한 도구가 생성자임!!
class Room(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String
//  나중에 데이터클래스를 통으로 Intent로 넘겨주기 위해서 Serializable을 상속받는다 라는 의미로 적어준다.
    ) : Serializable {

//  12000 => 1억 2,000만원 으로 표현할 수 있게 가격을 정제해주는 함수(fun)을 만들어준다. 이러면 어디에서든 사용 가능하다. 그리고 이 데이터클래스 안에서의 일이므로
//  this.~~로 표현해준다.
    fun getFormattedPrice () : String {
//  가격을 10000으로 나누고 떨어지는 자리/나머지 자리 를 각각 변수로 저장해두고 return에서 사이에 텍스트로 이어준다.

//      this.price 등과 같이 앞에 this를 쓰는 이유는 현재 클라스의 생성자나 특정 프로퍼티 및 메소드를 참조하기 위해서이다.

        if (this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000
//          세번째 숫자마다 ,을 찍어주는 기능이다.
            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}만원"
        }
        else{
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}만"
        }

    }
//  -2 => 지하 2층 등과 같이 위와 같이 층수를 정제화해주는 함수를 만든다.
    fun getFormattedFloor() : String {

        if(this.floor > 0){
            return " ${this.floor}층"
        }
        else if (this.floor == 0){
            return " 반지하"
        }
        else{
//          부호를 바꿔주기 위해서는 그냥 변수 바로 앞에 -를 붙여주면 된다.
            return " 지하${-this.floor}층"
        }

    }

}