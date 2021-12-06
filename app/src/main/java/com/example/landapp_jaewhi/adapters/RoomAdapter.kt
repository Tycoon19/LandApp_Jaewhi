package com.example.landapp_jaewhi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.landapp_jaewhi.R
import com.example.landapp_jaewhi.datas.Room
import kotlin.math.floor

class RoomAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Room>
) : ArrayAdapter<Room>(mContext, resId, mList){

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null){
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

        val roomData = mList[position]

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val floorTxt = row.findViewById<TextView>(R.id.floorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

        priceTxt.text = roomData.price.toString()
        addressTxt.text = roomData.address
        floorTxt.text = " ${roomData.floor.toString()}층"
        descriptionTxt.text = roomData.description



        return row
    }

}