package com.example.landapp_jaewhi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.landapp_jaewhi.R
import com.example.landapp_jaewhi.datas.Room
import java.text.DecimalFormat
import kotlin.math.floor
//  이 클래스는 ArrayAdapter를 상속받아야 하는데 이는 기본생성자를 지원하지 않기 때문에 직접 필요한 생성자를 만들어줘야 한다.
class RoomAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Room>
//
) : ArrayAdapter<Room>(mContext, resId, mList){
//  xml을 인플레이터 해주는 멤버변수를 선언해준다. xml을 객체화시켜준다?ㅇ?
    val inf = LayoutInflater.from(mContext)
//  getView 함수를 빌려와서 우리 입맛에 따라 바꿔 쓸 수 있도록 override 해준다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//      convertView를 바로 쓸 수 없기 때문에 tempRow(임시로우)로 바꿔준다.
        var tempRow = convertView
//      tempRow는 재사용할 수 있는 row를 뜻한다. 이게 없을때는 새로 만들어달라는 조건문을 만들어준다.
        if (tempRow == null){
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }
//      위 조건문에 따라 tempRow는 절대 null값이 존재할 수 없으므로 실제 row값으로 정의해준다.
        val row = tempRow!!
//      각 줄에 따른 정보들을 담는 변수를 만들어준다.
        val roomData = mList[position]
//      row 변수 내부의 UI들을 id를 붙여서 가져오자.
//
        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val floorTxt = row.findViewById<TextView>(R.id.floorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

        priceTxt.text = roomData.getFormattedPrice()
        addressTxt.text = roomData.address
        floorTxt.text = roomData.getFormattedFloor()
        descriptionTxt.text = roomData.description



        return row
    }

}