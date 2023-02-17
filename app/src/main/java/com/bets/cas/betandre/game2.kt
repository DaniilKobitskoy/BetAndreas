package com.bets.cas.betandre

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bets.cas.betandre.databinding.FragmentGame2Binding
 var timer: CountDownTimer? = null

class game2 : Fragment() {

lateinit var binding: FragmentGame2Binding
    private lateinit var tapButton: Button
    private var taps: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGame2Binding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tapButton = binding.tapButton
        binding.imageView2.setOnClickListener {
            bindingMain.cont.visibility = View.GONE
            bindingMain.button.visibility = View.VISIBLE
            bindingMain.button2.visibility = View.VISIBLE
            bindingMain.button3.visibility = View.VISIBLE
        }
        tapButton.setOnClickListener {
            taps++
            tapButton.text = "Taps: $taps"

        }

        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerTextView.setText("Time Left: ${millisUntilFinished / 1000}")
            }

            override fun onFinish() {
                tapButton.isEnabled = false
                binding.timerTextView.text = "Time's up!"
            }
        }


    }

    override fun onResume() {
        super.onResume()
        timer?.start()
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
    }
}