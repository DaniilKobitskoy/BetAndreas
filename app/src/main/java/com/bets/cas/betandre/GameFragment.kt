package com.bets.cas.betandre

import android.annotation.SuppressLint


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import com.bets.cas.betandre.databinding.FragmentGameBinding

class GameFragment : Fragment() {
lateinit var binding: FragmentGameBinding
    private lateinit var scoreText: TextView
    private lateinit var timeText: TextView
    private lateinit var tapButton: Button

    private var score = 0
    private var timeLimit = 10 // in seconds
    private var gameTimer: CountDownTimer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        scoreText = view.findViewById(R.id.score_text)
        timeText = view.findViewById(R.id.time_text)
        tapButton = view.findViewById(R.id.tap_button)
        binding.imageView.setOnClickListener {
            bindingMain.cont.visibility = View.GONE
            bindingMain.button.visibility = View.VISIBLE
            bindingMain.button2.visibility = View.VISIBLE
            bindingMain.button3.visibility = View.VISIBLE
        }
        tapButton.setOnClickListener {
            score++
            scoreText.text = "Score: $score"
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        startGame()
    }

    private fun startGame() {
        gameTimer = object : CountDownTimer((timeLimit * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                showGameOverDialog()
            }
        }
        gameTimer?.start()
    }

    private fun showGameOverDialog() {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Game Over")
            .setMessage("Your score is $score")
            .setPositiveButton("Play Again") { _, _ ->
                resetGame()
            }
            .setNegativeButton("Menu") { _, _ ->
              bindingMain.cont.visibility = View.GONE
                bindingMain.button.visibility = View.VISIBLE
                bindingMain.button2.visibility = View.VISIBLE
            }
            .setCancelable(false)
            .create()
        dialog.show()
    }

     fun resetGame() {
        score = 0
        scoreText.text = "Score: 0"
        gameTimer?.cancel()
        startGame()
    }
}
