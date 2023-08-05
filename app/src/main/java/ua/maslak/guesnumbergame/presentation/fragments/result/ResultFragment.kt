package ua.maslak.guesnumbergame.presentation.fragments.result

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import ua.maslak.guesnumbergame.R
import ua.maslak.guesnumbergame.databinding.FragmentResultBinding
import ua.maslak.guesnumbergame.presentation.MainActivity
import ua.maslak.guesnumbergame.presentation.fragments.BaseFragment

class ResultFragment: BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val successfulAttempts = args.success
        val unsuccessfulAttempts = args.unsuccess
        binding.textViewResults1.text = getString(R.string.successful) + successfulAttempts
        binding.textViewResults2.text = getString(R.string.unsuccessful) + unsuccessfulAttempts
    }

    @SuppressLint("IntentWithNullActionLaunch")
    override fun setListeners() {
        binding.buttonMenu.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            requireActivity().finish()
        }
    }
}