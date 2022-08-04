package com.example.basicapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignNumbersToButton()
        leftBtn.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButton()
        }
        rightBtn.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButton()
        }
    }

    private fun checkAnswer(isLeftButtonClicked: Boolean) {
        val leftNum = leftBtn.text.toString().toInt()
        val rightNum = rightBtn.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonClicked) leftNum >= rightNum else rightNum >= leftNum
        if (isAnswerCorrect) {
            background.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            background.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }


    private fun assignNumbersToButton() {
        val r = Random
        val leftNum = r.nextInt(10)
        val rightNum = r.nextInt(10)
        leftBtn.text = leftNum.toString();
        rightBtn.text = rightNum.toString();
    }
}