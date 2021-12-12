package com.example.landapp_jaewhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgroundImage: ImageView = findViewById(R.id.upLongArrowImv)
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_splash_imageview)
        backgroundImage.startAnimation(animation)


            val myHandler = Handler(Looper.getMainLooper())

//      각종 데이터 확인 등 => 앱을 실행하기 전에 필요한 사전 작업 수행

        myHandler.postDelayed({

//         2.5초 후에 실행할 내용 작성
//         메인화면으로 이동 + 지금 화면 종료
          val myIntent = Intent(this, MainActivity::class.java)
          startActivity(myIntent)
          finish()

        }, 2500)

    }

}