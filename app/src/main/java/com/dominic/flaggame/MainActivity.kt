package com.dominic.flaggame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.dominic.flaggame.Data.Save
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animat()

        val sharedPreferences = getSharedPreferences("record", MODE_PRIVATE)
        score.text = "Score: ${sharedPreferences.getString("record","")}"
      btn_start.setOnClickListener {
          val intent = Intent(this,GameActivity::class.java)
          startActivity(intent)

      }

    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("record", MODE_PRIVATE)
        score.text = "Score: ${sharedPreferences.getString("record","")}"
        val editor  = sharedPreferences.edit()
        editor.putString("record",Save.record.toString())
        editor.apply()

    }
    fun animat(){
        val animation = AnimationUtils.loadAnimation(this,R.anim.startgame)
        flagGameTag.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                animat()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }
}