package com.example.landapp_jaewhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.landapp_jaewhi.adapters.RoomAdapter
import com.example.landapp_jaewhi.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//  실제 목록을 담을 mRoomList를 멤버변수로 만들고 ArrayList로 Room정보를 담는다.
    val mRoomList = ArrayList<Room>()
//  nullable하지 않은 변수를 선언하면서 assign하는 작업을 뒤로 미루고 싶기 때문.(코드 상에서는 null이 될 수 있지만 실제 작동 중에는
//  절대 null이 될 순 없음.) -> 설마..? mAdapter는 데이터를 담아서 전달해줘야 하는데 나중에 add data를 DB에서 불러올 땐 불러오기 전까지 비어있어서..? 호옹..
    lateinit var mAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      mRoomList에 실제 Room데이터를 직.접. 입력해준다. 나중엔 DB에서 불러와야 함.
        mRoomList.add( Room( 7500, "서울시 동대문구", 8, "서울시 동대문구의 8층 7500만원 방 입니다." ) )
        mRoomList.add( Room( 24500, "서울시 서대문구", 0, "서울시 서대문구의 반지하 2억 4500만원 방 입니다." ) )
        mRoomList.add( Room( 8500, "서울시 동작구", 0, "서울시 동작구의 반지하 8500만원 방 입니다." ) )
        mRoomList.add( Room( 4500, "서울시 은평구", -2, "서울시 은평구의 지하 2층 4500만원 방 입니다." ) )
        mRoomList.add( Room( 182500, "서울시 중랑구", 5, "서울시 중랑구의 5층 1억 18억 2500만원 방 입니다." ) )
        mRoomList.add( Room( 235000, "서울시 도봉구", 7, "서울시 도봉구의 7층 1억 23억 5000만원 방 입니다." ) )
        mRoomList.add( Room( 24000, "서울시 강남구", 19, "서울시 강남구의 19층 2억 4000만원 방 입니다." ) )
        mRoomList.add( Room( 3700, "서울시 서초구", -1, "서울시 서초구의 지하 1층 3700만원 방 입니다." ) )

//      이게 왜 객체화지..? 객체화 개념 확실하게 익히고 가기.. Adapter 클래스(RoomAdapter)를 객체화한다는데...
        mAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
//      activity_main의 리스트뷰의 어댑터를 mAdapter로 지정.
        roomListView.adapter = mAdapter

        roomListView.setOnItemClickListener { parent, view, position, id ->

            val clickedRoom = mRoomList[position]
            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)
            myIntent.putExtra("room",clickedRoom)
            startActivity(myIntent)

        }

    }
}