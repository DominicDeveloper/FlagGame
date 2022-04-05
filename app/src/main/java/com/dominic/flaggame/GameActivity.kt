package com.dominic.flaggame
// Dominic Developer
// App version 1.0
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.dominic.flaggame.Data.Save
import com.dominic.flaggame.Server.GameOver
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var repeated = 0
    var recordsaver = 0
    var word:String = ""
    var arrivedword = ""
    var answerKey:String = ""
    val country = arrayOf("argentina","brazil","china","germany","france","india","korea","pakistan","russia","turkey","america","uzbekistan")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        nextto()

        recordnow.text = "Record: $recordsaver"
        card_1.setOnClickListener {
            startanimations(card_1)
            this.word += text_1.text.toString()
            card_1.isClickable = false
            answer.text = "${word}"
            card_1.visibility = View.INVISIBLE
            checking()

        }
        card_2.setOnClickListener {
            startanimations(card_2)
            this.word += text_2.text.toString()
            card_2.isClickable = false
            answer.text = "${word}"
            card_2.visibility = View.INVISIBLE
            checking()

        }
        card_3.setOnClickListener {
            startanimations(card_3)
            this.word += text_3.text.toString()
            card_3.isClickable = false
            answer.text = "${word}"
            card_3.visibility = View.INVISIBLE
            checking()

        }
        card_4.setOnClickListener {
            startanimations(card_4)
            this.word += text_4.text.toString()
            card_4.isClickable = false
            answer.text = "${word}"
            card_4.visibility = View.INVISIBLE
            checking()

        }
        card_5.setOnClickListener {
            startanimations(card_5)
            this.word += text_5.text.toString()
            card_5.isClickable = false
            answer.text = "${word}"
            card_5.visibility = View.INVISIBLE
            checking()

        }
        card_6.setOnClickListener {
            startanimations(card_6)
            this.word += text_6.text.toString()
            card_6.isClickable = false
            answer.text = "${word}"
            card_6.visibility = View.INVISIBLE
            checking()

        }
        card_7.setOnClickListener {
            startanimations(card_7)
            this.word += text_7.text.toString()
            card_7.isClickable = false
            answer.text = "${word}"
            card_7.visibility = View.INVISIBLE
            checking()

        }
        card_8.setOnClickListener {
            startanimations(card_8)
            this.word += text_8.text.toString()
            card_8.isClickable = false
            answer.text = "${word}"
            card_8.visibility = View.INVISIBLE
            checking()

        }
        card_9.setOnClickListener {
            startanimations(card_9)
            this.word += text_9.text.toString()
            card_9.isClickable = false
            answer.text = "${word}"
            card_9.visibility = View.INVISIBLE
            checking()

        }
        answerslaoyut.setOnClickListener {
            if (answer.text.isNotEmpty()){
                if (answer.text.subSequence(word.length-1,word.length) == text_1.text){
                    card_1.visibility = View.VISIBLE
                    card_1.isClickable = true

                }else if (answer.text.subSequence(word.length-1,word.length) == text_2.text){
                    card_2.visibility = View.VISIBLE
                    card_2.isClickable = true
                }else if(answer.text.subSequence(word.
                    length-1,word.length) == text_3.text)
                {
                    card_3.visibility = View.VISIBLE
                    card_3.isClickable = true
                }else if(answer.text.subSequence(word.length-1,word.length) == text_4.text){
                    card_4.visibility = View.VISIBLE
                    card_4.isClickable = true
                }else if (answer.text.subSequence(word.length-1,word.length) == text_5.text)
                {
                    card_5.visibility = View.VISIBLE
                    card_5.isClickable = true
                }else if(answer.text.subSequence(word.length-1,word.length) == text_6.text){
                    card_6.visibility = View.VISIBLE
                    card_6.isClickable = true
                }else if(answer.text.subSequence(word.length-1,word.length) == text_7.text){
                    card_7.visibility = View.VISIBLE
                    card_7.isClickable = true
                }else if(answer.text.subSequence(word.length-1,word.length) == text_8.text){
                    card_8.visibility = View.VISIBLE
                    card_8.isClickable = true
                }else if(answer.text.subSequence(word.length-1,word.length) == text_9.text){
                    card_9.visibility = View.VISIBLE
                    card_9.isClickable = true
                }
                word =  word.subSequence(0,word.length-1).toString()
                answer.text = answer.text.subSequence(0,answer.text.length-1)
                if (answer.text.isEmpty()){
                    visiableAll()
                    ClicableAll()
                }

            }


        }


    }
    @SuppressLint("SetTextI18n")
    fun checking(){
        if(country[repeated].length == answer.text.length){
            if (answer.text == country[repeated].toUpperCase())
            {
                repeated++
                recordsaver++
                Save.record = recordsaver
                recordnow.text = "Record: $recordsaver"
                Toast.makeText(this, "Well Done!", Toast.LENGTH_SHORT).show()
                visiableAll()
                ClicableAll()
                answer.text = ""
                word = ""
                nextto()


            }else{
                if (first_heart.isVisible){
                    first_heart.setImageResource(R.drawable.broken_1)
                    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    v.vibrate(200)
                    brokenanimation(first_heart)
                }else if(!first_heart.isVisible && second_heart.isVisible){
                    second_heart.setImageResource(R.drawable.broken_1)
                    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    v.vibrate(200)
                    brokenanimation(second_heart)
                }
                else if(!first_heart.isVisible && !second_heart.isVisible && thrid_heart.isVisible){
                    thrid_heart.setImageResource(R.drawable.broken_1)
                    brokenanimation(thrid_heart)
                    GameOver.gameover = true
                    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    v.vibrate(400)
                    val goRestart = Intent(this,EndGame::class.java)
                    startActivity(goRestart)
                   // onDestroy()

                }
                Toast.makeText(this, "InCorrect answer!", Toast.LENGTH_SHORT).show()
                visiableAll()
                ClicableAll()
                answer.text = ""
                word = ""
            }
         /*
            val sharedPreferences = getSharedPreferences("record", MODE_PRIVATE)
            val editor  = sharedPreferences.edit()
            editor.putString("record",Save.record.toString())
            editor.apply()
            sharedPreferences.getString("record","Score: 0")
          */
        }

    }
    fun startanimations(Card:CardView){
        val anim = AnimationUtils.loadAnimation(this,R.anim.put_anim)
        Card.startAnimation(anim)

    }
    fun brokenanimation(image:ImageView){
        val img = AnimationUtils.loadAnimation(this,R.anim.removeheart)
        image.startAnimation(img)
        img.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                image.visibility = View.INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }
    fun nextto(){

            when(repeated){

                0 -> {
                    answerKey = country[0]
                    img.setImageResource(R.drawable.country_ar)
                    ViewWords()
                }
                1 -> {
                    answerKey = country[1]
                    img.setImageResource(R.drawable.country_br)
                    ViewWords()
                }
                2 -> {
                    answerKey = country[2]
                    img.setImageResource(R.drawable.country_cn)
                    ViewWords()
                }
                3 -> {
                    answerKey = country[3]
                    img.setImageResource(R.drawable.country_de)
                    ViewWords()
                }
                4 -> {
                    answerKey = country[4]
                    img.setImageResource(R.drawable.country_fr)
                    ViewWords()
                }
                5 -> {
                    answerKey = country[5]
                    img.setImageResource(R.drawable.country_in)
                    ViewWords()
                }
                6 -> {
                    answerKey = country[6]
                    img.setImageResource(R.drawable.country_kr)
                    ViewWords()
                }
                7 -> {
                    answerKey = country[7]
                    img.setImageResource(R.drawable.country_pk)
                    ViewWords()
                }
                8 -> {
                    answerKey = country[8]
                    img.setImageResource(R.drawable.country_ru)
                    ViewWords()
                }
                9 -> {
                    answerKey = country[9]
                    img.setImageResource(R.drawable.country_tr)
                    ViewWords()
                }
                10 -> {
                    answerKey = country[10]
                    img.setImageResource(R.drawable.country_us)
                    ViewWords()
                }
                11 -> {
                    answerKey = country[11]
                    img.setImageResource(R.drawable.country_uz)
                    ViewWords()
                }
                else ->{
                    val goWinner = Intent(this,EndGame::class.java)
                    GameOver.gameover = false
                    startActivity(goWinner)

                }

            }




    }
    fun ViewWords(){
        when(repeated){
            0->{
                visiable_ar()
            }1->{
                visiable_br()
            }2->{
                visiable_cn()
            }3->{
                visiable_de()
            }4->{
                visiable_fr()
            }5->{
                visiable_in()
            }6->{
                visiable_kr()
            }7->{
                visiable_pk()
            }8->{
                visiable_ru()
            }9->{
                visiable_tr()
            }10->{
                visiable_us()
            }11->{
                visiable_uz()
            }
        }

    }
    fun visiable_ar(){
        card_1.visibility = View.VISIBLE
        card_2.visibility = View.VISIBLE
        card_3.visibility = View.VISIBLE
        card_4.visibility = View.VISIBLE
        card_5.visibility = View.VISIBLE
        card_6.visibility = View.VISIBLE
        card_7.visibility = View.VISIBLE
        card_8.visibility = View.VISIBLE
        card_9.visibility = View.VISIBLE
        text_1.text = "R"
        text_2.text = "A"
        text_3.text = "N"
        text_4.text = "N"
        text_5.text = "E"
        text_6.text = "I"
        text_7.text = "T"
        text_8.text = "G"
        text_9.text = "A"


    }
    fun visiable_br(){

        text_1.text = "A"
        text_2.text = "S"
        text_3.text = "I"
        text_4.text = "L"
        text_5.text = "B"
        text_6.text = "R"
        text_7.text = "Z"
        text_8.text = "M"
        text_9.text = "D"




    }
    fun visiable_cn(){
        text_1.text = "C"
        text_2.text = "I"
        text_3.text = "M"
        text_4.text = "N"
        text_5.text = "H"
        text_6.text = "X"
        text_7.text = "A"
        text_8.text = "R"
        text_9.text = "K"

    }
    fun visiable_de(){

        text_1.text = "Y"
        text_2.text = "A"
        text_3.text = "M"
        text_4.text = "R"
        text_5.text = "E"
        text_6.text = "N"
        text_7.text = "G"
        text_8.text = "K"
        text_9.text = "L"
    }
    fun visiable_fr(){

        text_1.text = "F"
        text_2.text = "C"
        text_3.text = "A"
        text_4.text = "R"
        text_5.text = "N"
        text_6.text = "E"
        text_7.text = "N"
        text_8.text = "T"
        text_9.text = "A"
    }
    fun visiable_in(){

        text_1.text = "I"
        text_2.text = "A"
        text_3.text = "P"
        text_4.text = "D"
        text_5.text = "K"
        text_6.text = "N"
        text_7.text = "S"
        text_8.text = "T"
        text_9.text = "I"
    }
    fun visiable_kr(){

        text_1.text = "K"
        text_2.text = "X"
        text_3.text = "A"
        text_4.text = "S"
        text_5.text = "E"
        text_6.text = "T"
        text_7.text = "R"
        text_8.text = "R"
        text_9.text = "O"
    }
    fun visiable_pk(){

        text_1.text = "P"
        text_2.text = "N"
        text_3.text = "T"
        text_4.text = "S"
        text_5.text = "I"
        text_6.text = "K"
        text_7.text = "N"
        text_8.text = "A"
        text_9.text = "A"
    }
    fun visiable_ru(){

        text_1.text = "R"
        text_2.text = "Y"
        text_3.text = "A"
        text_4.text = "S"
        text_5.text = "A"
        text_6.text = "U"
        text_7.text = "U"
        text_8.text = "S"
        text_9.text = "I"
    }
    fun visiable_tr(){

        text_1.text = "T"
        text_2.text = "U"
        text_3.text = "R"
        text_4.text = "E"
        text_5.text = "L"
        text_6.text = "K"
        text_7.text = "A"
        text_8.text = "S"
        text_9.text = "Y"
    }
    fun visiable_us(){

        text_1.text = "A"
        text_2.text = "R"
        text_3.text = "H"
        text_4.text = "E"
        text_5.text = "C"
        text_6.text = "I"
        text_7.text = "C"
        text_8.text = "M"
        text_9.text = "A"
    }
    @SuppressLint("SetTextI18n")
    fun visiable_uz(){

        text_1.text = "T"
        text_2.text = "I"
        text_3.text = "S"
        text_4.text = "A"
        text_5.text = "K"
        text_6.text = "E"
        text_7.text = "B"
        text_8.text = "UZ"
        text_9.text = "N"
    }
    fun visiableAll(){
        card_1.isVisible = true
        card_2.isVisible = true
        card_3.isVisible = true
        card_4.isVisible = true
        card_5.isVisible = true
        card_6.isVisible = true
        card_7.isVisible = true
        card_8.isVisible = true
        card_9.isVisible = true
    }
    fun ClicableAll(){
        card_1.isClickable = true
        card_2.isClickable = true
        card_3.isClickable = true
        card_4.isClickable = true
        card_5.isClickable = true
        card_6.isClickable = true
        card_7.isClickable = true
        card_8.isClickable = true
        card_9.isClickable = true


    }

}