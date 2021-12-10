package com.example.landapp_jaewhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({

//         2.5초 후에 실행할 내용 작성
//         메인화면으로 이동 + 지금 화면 종료

          val myIntent = Intent(this, MainActivity::class.java)
          startActivity(myIntent)
          finish()

        }, 2500)

    }
}