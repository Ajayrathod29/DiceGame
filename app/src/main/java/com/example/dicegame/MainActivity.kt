package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicegame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var player1 : Int = 0
    private var winScore : Int = 50
    private var player2 : Int = 0
    private var currentPlayer : Int =1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dicebutton.setOnClickListener {
            val randomNum = Random.nextInt(6) + 1
            val dice = when (randomNum) {
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }
            binding.diceimageView.setImageResource(dice)
            if (currentPlayer == 1) {
                player1 += randomNum
                binding.p1Text.text = player1.toString()
                currentPlayer = 2
            } else {
                player2 += randomNum
                binding.p2Text.text = player2.toString()
                currentPlayer = 1
            }
            if (player1 >= winScore) {
                binding.resultText.text = "Player One Is Win"
                binding.dicebutton.text = "Play Again"
                if (binding.dicebutton.text == "Play Again") {
                    binding.dicebutton.setOnClickListener {
                        recreate()
                    }

                }
                    }
                    else if (player2 >= winScore) {
                        binding.resultText.text = "Player Two is Win"
                        binding.dicebutton.text = "Play Again"
                        if (binding.dicebutton.text == "Play Again") {
                            binding.dicebutton.setOnClickListener {
                                recreate()
                            }
                        }
                    }
                    binding.current.text = "Current Player: Player $currentPlayer"
                }


            }
        }


