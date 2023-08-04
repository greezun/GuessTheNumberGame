package ua.maslak.guesnumbergame.presentation.fragments.game

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ua.maslak.guesnumbergame.databinding.FragmentGameBinding
import ua.maslak.guesnumbergame.presentation.fragments.BaseFragment
import java.util.Random


@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    private var secretNumber: Int = 0
    private var successfulAttempts: Int = 0
    private var unsuccessfulAttempts: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGame()

    }



    private fun setButtonVisible() {
        if (successfulAttempts != 0 || unsuccessfulAttempts != 0){
            Log.d("myTag", "$successfulAttempts  $unsuccessfulAttempts ")
            binding.buttonResult.visibility = View.VISIBLE
        }

    }

    private fun startGame() {
setButtonVisible()
        val text =
            if (successfulAttempts == 0 && unsuccessfulAttempts == 0) "Я загадав число від 0 до 99, зможеш відгадати?" else "Я знову загадав число від 0 до 99, зможеш відгадати?"

        binding.textViewStart.text = text


        val random = Random()
        secretNumber = random.nextInt(100)

        Log.d("myTag", "secretNumber $secretNumber")


    }


    private fun checkGuess() {

        with(binding) {
            val guessStr = editTextField.text.toString()
            if (guessStr.isNotEmpty()) {
                val guess = guessStr.toInt()
                if (guess == secretNumber) {
                    textViewStart.text = "Вітаю, ти відгадав, спробуємо ще раз?"
                    successfulAttempts++

                } else {
                    textViewStart.text = "Не вгадав, спробуємо ще раз?"
                    unsuccessfulAttempts++
                }
                editTextField.text.clear()

                Handler(Looper.getMainLooper()).postDelayed({
                    startGame()
                }, 1500)
            }
        }
    }

    override fun setListeners() {
        binding.buttonResult.setOnClickListener {
            val directions = GameFragmentDirections
                .actionGameFragmentToResultFragment(successfulAttempts, unsuccessfulAttempts)
            findNavController().navigate(directions)
        }

        binding.buttonVerify.setOnClickListener {
            checkGuess()
        }


    }
}