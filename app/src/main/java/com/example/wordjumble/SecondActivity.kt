package com.example.wordjumble

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val word: String? = intent.getStringExtra("WORD")
        val clue = intent.getStringExtra("CLUE")
        val clueBox = findViewById<TextView>(R.id.clueBox)
        val guess = findViewById<TextView>(R.id.guessBox)
        val p1= 500
        val p2= 300
        val p3= 100
        val sharedPref = getSharedPreferences("MY", MODE_PRIVATE)
        val editor = sharedPref.edit()
        var score = 0
        var highscore = 0
        guess.text = ""
        var d = 0
        val wordLength: Int? = word?.length
        var lives = 3
        val textClue = findViewById<TextView>(R.id.clueText)
        val iButton = findViewById<ImageButton>(R.id.iButton)
        val tryBtn = findViewById<Button>(R.id.btnTry)
        val reset = findViewById<ImageButton>(R.id.btnReset)
        val check = findViewById<ImageButton>(R.id.btnCheck)
        val okay = findViewById<Button>(R.id.btnOkay)
        val heart3 = findViewById<ImageView>(R.id.heart3)
        val heart2 = findViewById<ImageView>(R.id.heart2)
        val heart1 = findViewById<ImageView>(R.id.heart1)
        val homeBtn = findViewById<Button>(R.id.homebtn)
        val btn11 = findViewById<Button>(R.id.b11)
        val btn12 = findViewById<Button>(R.id.b12)
        val btn13 = findViewById<Button>(R.id.b13)
        val btn14 = findViewById<Button>(R.id.b14)
        val btn21 = findViewById<Button>(R.id.b21)
        val btn22 = findViewById<Button>(R.id.b22)
        val btn23 = findViewById<Button>(R.id.b23)
        val btn24 = findViewById<Button>(R.id.b24)
        val btn31 = findViewById<Button>(R.id.b31)
        val btn32 = findViewById<Button>(R.id.b32)
        val btn33 = findViewById<Button>(R.id.b33)
        val btn34 = findViewById<Button>(R.id.b34)
        val btn41 = findViewById<Button>(R.id.b41)
        val btn42 = findViewById<Button>(R.id.b42)
        val btn43 = findViewById<Button>(R.id.b43)
        val btn44 = findViewById<Button>(R.id.b44)
        check.isEnabled = false
        textClue.text = "$wordLength Letter Word:$clue"
        guess.textSize = 40f
        word?.uppercase()
        val list16 = mutableListOf<Char>()
        val numList = mutableListOf<Int>()
        val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var i = 0
        while (i < wordLength!!) {
            val m: Char = word[i]
            list16.add(i, m)
            i++
        }
        var j: Int = wordLength
        while (j < 16) {
            val k = (0..25).random()
            val n: Char = alphabets[k]
            list16.add(j, n)
            j++
        }
        while (numList.size < 16) {
            val g = (0..15).random()
            if (g in numList) {
                continue
            } else {
                numList.add(g)
            }
            fun high(){
                if (score>=highscore){
                    highscore=score
                }
            }
            fun invisiblebtn(){
                btn11.visibility = INVISIBLE
                btn12.visibility = INVISIBLE
                btn13.visibility = INVISIBLE
                btn14.visibility = INVISIBLE
                btn21.visibility = INVISIBLE
                btn22.visibility = INVISIBLE
                btn23.visibility = INVISIBLE
                btn24.visibility = INVISIBLE
            }
            fun visiblebtn(){
                btn11.visibility = VISIBLE
                btn12.visibility = VISIBLE
                btn13.visibility = VISIBLE
                btn14.visibility = VISIBLE
                btn21.visibility = VISIBLE
                btn22.visibility = VISIBLE
                btn23.visibility = VISIBLE
                btn24.visibility = VISIBLE
            }
            fun display(){
                btn11.setBackgroundResource(R.drawable.button)
                btn12.setBackgroundResource(R.drawable.button)
                btn13.setBackgroundResource(R.drawable.button)
                btn14.setBackgroundResource(R.drawable.button)
                btn21.setBackgroundResource(R.drawable.button)
                btn22.setBackgroundResource(R.drawable.button)
                btn23.setBackgroundResource(R.drawable.button)
                btn24.setBackgroundResource(R.drawable.button)
                btn31.setBackgroundResource(R.drawable.button)
                btn32.setBackgroundResource(R.drawable.button)
                btn33.setBackgroundResource(R.drawable.button)
                btn34.setBackgroundResource(R.drawable.button)
                btn41.setBackgroundResource(R.drawable.button)
                btn42.setBackgroundResource(R.drawable.button)
                btn43.setBackgroundResource(R.drawable.button)
                btn44.setBackgroundResource(R.drawable.button)
            }
            fun enablebtn(){
                btn11.isEnabled = true
                btn12.isEnabled = true
                btn13.isEnabled = true
                btn14.isEnabled = true
                btn21.isEnabled = true
                btn22.isEnabled = true
                btn23.isEnabled = true
                btn24.isEnabled = true
                btn31.isEnabled = true
                btn32.isEnabled = true
                btn33.isEnabled = true
                btn34.isEnabled = true
                btn41.isEnabled = true
                btn42.isEnabled = true
                btn43.isEnabled = true
                btn44.isEnabled = true
            }
            fun disablebtn(){
                btn11.isEnabled = false
                btn12.isEnabled = false
                btn13.isEnabled = false
                btn14.isEnabled = false
                btn21.isEnabled = false
                btn22.isEnabled = false
                btn23.isEnabled = false
                btn24.isEnabled = false
                btn31.isEnabled = false
                btn32.isEnabled = false
                btn33.isEnabled = false
                btn34.isEnabled = false
                btn41.isEnabled = false
                btn42.isEnabled = false
                btn43.isEnabled = false
                btn44.isEnabled = false
            }
            disablebtn()
            reset.setOnClickListener {
                display()
                enablebtn()
                guess.text = ""
                d = 0
            }
            tryBtn.setOnClickListener {
                display()
                enablebtn()
                iButton.isEnabled = true
                lives=3
                guess.text = ""
                d = 0
                tryBtn.visibility = INVISIBLE
                homeBtn.visibility = INVISIBLE
                textClue.visibility = INVISIBLE
                clueBox.visibility = INVISIBLE
                visiblebtn()
                heart3.setImageResource(R.drawable.pngfind_com_heart_background_png_1311892)
                heart2.setImageResource(R.drawable.pngfind_com_heart_background_png_1311892)
                heart1.setImageResource(R.drawable.pngfind_com_heart_background_png_1311892)
                textClue.text = "$wordLength Letter Word:$clue"
                clueBox.text = "CLUE"
                clueBox.setBackgroundColor(R.drawable.cluebox)
                check.isEnabled=false


            }
            iButton.setOnClickListener {
                textClue.visibility = VISIBLE
                okay.visibility = VISIBLE
                clueBox.visibility = VISIBLE
                invisiblebtn()
                btn11.text = list16[numList[1]].toString()
                btn12.text = list16[numList[2]].toString()
                btn13.text = list16[numList[3]].toString()
                btn14.text = list16[numList[4]].toString()
                btn21.text = list16[numList[5]].toString()
                btn22.text = list16[numList[6]].toString()
                btn23.text = list16[numList[7]].toString()
                btn24.text = list16[numList[8]].toString()
                btn31.text = list16[numList[9]].toString()
                btn32.text = list16[numList[10]].toString()
                btn33.text = list16[numList[11]].toString()
                btn34.text = list16[numList[12]].toString()
                btn41.text = list16[numList[13]].toString()
                btn42.text = list16[numList[14]].toString()
                btn43.text = list16[numList[15]].toString()
                btn44.text = list16[numList[0]].toString()

            }

            okay.setOnClickListener {
                clueBox.setBackgroundColor(R.drawable.cluebox)
                textClue.visibility = INVISIBLE
                okay.visibility = INVISIBLE
                clueBox.visibility = INVISIBLE
                visiblebtn()
                enablebtn()
            }

            btn11.setOnClickListener {
                btn11.setBackgroundResource(R.drawable.btn2)
                guess.append(list16[numList[1]].toString())
                btn11.isEnabled = false
                d++
                if (d == wordLength) {
                    disablebtn()
                    check.isEnabled = true
                }

            }
            btn12.setOnClickListener {
                btn12.setBackgroundResource(R.drawable.btn2)
                guess.append(list16[numList[2]].toString())
                btn12.isEnabled = false
                d++
                if (d == wordLength) {
                    disablebtn()
                    check.isEnabled = true
                }
            }
            btn13.setOnClickListener {
                btn13.setBackgroundResource(R.drawable.btn2)
                guess.append(list16[numList[3]].toString())
                btn13.isEnabled = false
                d++
                if (d == wordLength) {
                    disablebtn()
                    check.isEnabled = true
                }
            }
                btn14.setOnClickListener {
                    btn14.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[4]].toString())
                    btn14.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn21.setOnClickListener {
                    btn21.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[5]].toString())
                    btn21.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn22.setOnClickListener {
                    btn22.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[6]].toString())
                    btn22.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn23.setOnClickListener {
                    btn23.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[7]].toString())
                    btn23.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn24.setOnClickListener {
                    btn24.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[8]].toString())
                    btn24.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn31.setOnClickListener {
                    btn31.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[9]].toString())
                    btn31.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn32.setOnClickListener {
                    btn32.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[10]].toString())
                    btn32.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn33.setOnClickListener {
                    btn33.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[11]].toString())
                    btn33.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn34.setOnClickListener {
                    btn34.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[12]].toString())
                    btn34.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn41.setOnClickListener {
                    btn41.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[13]].toString())
                    btn41.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn42.setOnClickListener {
                    btn42.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[14]].toString())
                    btn42.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn43.setOnClickListener {
                    btn43.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[15]].toString())
                    btn43.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }
                btn44.setOnClickListener {
                    btn44.setBackgroundResource(R.drawable.btn2)
                    guess.append(list16[numList[0]].toString())
                    btn44.isEnabled = false
                    d++
                    if (d == wordLength) {
                        disablebtn()
                        check.isEnabled = true
                    }
                }


                check.setOnClickListener {
                    val home = Intent(this, MainActivity::class.java)
                    clueBox.setBackgroundColor(R.drawable.cluebox)
                    iButton.isEnabled = false
                    check.isEnabled = false
                    if (guess.text.toString() == word) {

                        when (lives) {
                            3 -> score = p1
                            2 -> score = p2
                            1 -> score = p3
                        }
                        high()
                        editor.apply {
                            putInt("highScore", highscore)
                            apply()
                        }

                        textClue.text="SCORE:$score"
                        clueBox.text = "GAME OVER"
                        textClue.visibility = VISIBLE
                        clueBox.visibility = VISIBLE
                        homeBtn.visibility = VISIBLE
                        tryBtn.visibility = VISIBLE
                        invisiblebtn()
                    } else {
                        enablebtn()
                        display()
                        guess.text = ""
                        d = 0
                        lives--
                        when (lives) {
                            2 -> heart3.setImageResource(R.drawable.daco_5079634)
                            1 -> heart2.setImageResource(R.drawable.daco_5079634)
                            0 -> heart1.setImageResource(R.drawable.daco_5079634)
                        }

                        if (lives == 0) {
                            textClue.text = ""
                            textClue.visibility = VISIBLE
                            clueBox.text = "GAME OVER"
                            clueBox.visibility = VISIBLE
                            homeBtn.visibility = VISIBLE
                            tryBtn.visibility = VISIBLE
                            invisiblebtn()
                            iButton.isEnabled = false

                        }
                        iButton.isEnabled = true
                        clueBox.setBackgroundColor(R.drawable.cluebox)

                    }
                    homeBtn.setOnClickListener {
                        startActivity(home)
                    }
                   }
        }

    }
}



