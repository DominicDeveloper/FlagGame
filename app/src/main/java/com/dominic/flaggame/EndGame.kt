package com.dominic.flaggame

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.dominic.flaggame.Data.Save
import com.dominic.flaggame.Server.GameOver
import kotlinx.android.synthetic.main.activity_end_game.*
import android.os.Vibrator




class EndGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        ScannerMe()

        btn_restart.setOnClickListener {
            val RestartGame =  Intent(this,GameActivity::class.java)
            startActivity(RestartGame)
        }




    }
    @SuppressLint("SetTextI18n")
    fun ScannerMe(){

        if (GameOver.gameover == true){

            endgame.visibility = View.VISIBLE
            viewrecord.text = "Your score: ${Save.record}"
            val gameoveranim = AnimationUtils.loadAnimation(this,R.anim.game_over)
            endgame.startAnimation(gameoveranim)
            gameoveranim.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    endgame.startAnimation(gameoveranim)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        }else{
            endgame.visibility = View.INVISIBLE
        viewrecord.text = "Your score: ${Save.record}"}

    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }


}
