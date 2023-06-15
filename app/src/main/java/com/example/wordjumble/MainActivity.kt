package com.example.wordjumble

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        val wordEditText = findViewById<EditText>(R.id.edWord)
        val clueEditText = findViewById<EditText>(R.id.edClue)
        val startButton = findViewById<ImageButton>(R.id.btnStart)
        val hs = findViewById<TextView>(R.id.highScore)
        val sharedPref = getSharedPreferences("MY", MODE_PRIVATE)
        val highScore= sharedPref.getInt("highScore", 0)
        hs.text="$highScore"
        startButton.setOnClickListener {
            val enteredWord = wordEditText.text.toString().uppercase()
            val enteredClue = clueEditText.text.toString().uppercase()
            if (enteredWord == "" || enteredClue == "") {
                Toast.makeText(
                    this@MainActivity,
                    "Please enter the word and clue",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                intent.putExtra("WORD", enteredWord)
                intent.putExtra("CLUE", enteredClue)
                startActivity(intent)
            }
        }



    }


}





