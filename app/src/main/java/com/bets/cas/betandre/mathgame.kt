package com.bets.cas.betandre

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bets.cas.betandre.databinding.FragmentGame2Binding
import com.bets.cas.betandre.databinding.FragmentMathgameBinding


class mathgame : Fragment() {
    lateinit var binding: FragmentMathgameBinding
   // private lateinit var expressionText: TextView
   // private lateinit var guessText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMathgameBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.expressionText = binding.expressionText
//        binding.guessText = binding.guessText
        //val submitBtn: Button = binding.submitBtn
        binding.imageView3.setOnClickListener {
            bindingMain.cont.visibility = View.GONE
            bindingMain.button.visibility = View.VISIBLE
            bindingMain.button2.visibility = View.VISIBLE
            bindingMain.button3.visibility = View.VISIBLE
        }
        binding.expressionText.text = generateExpression()

        binding.submitBtn.setOnClickListener {
            onSubmit()
        }

    }
    private fun generateExpression(): String {
        val num1 = (1..10).random()
        val num2 = (1..10).random()
        val operator = arrayOf("+", "-", "*", "/").random()
        return "$num1 $operator $num2"
    }

    private fun checkAnswer(guess: Int): Boolean {
        Log.d("GameFragment", "Success: $guess")
        val parts =  binding.expressionText.text.toString().split(" ")
        val num1 = parts[0].toInt()
        val num2 = parts[2].toInt()
        val operator = parts[1]
        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("Invalid operator")
        }
        return guess == result
    }

    private fun onSubmit() {
        Log.d("GameFragment", "Submit button clicked")
        val guessString =  binding.guessText.text.toString()
        if (guessString.isBlank()) {
            return
        }
        val guess = guessString.toInt()
        val success = checkAnswer(guess)
        if (success) {
            Toast.makeText(context, "You guessed correctly!", Toast.LENGTH_SHORT).show()
            binding.expressionText.text = generateExpression()
            binding.guessText.setText("")
        } else {
            Toast.makeText(context, "Sorry, try again!", Toast.LENGTH_SHORT).show()
            binding.guessText.setText("")
        }
    }

}