package ua.maslak.guesnumbergame.presentation.fragments.result

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import ua.maslak.guesnumbergame.databinding.FragmentResultBinding
import ua.maslak.guesnumbergame.presentation.MainActivity
import ua.maslak.guesnumbergame.presentation.fragments.BaseFragment

class ResultFragment: BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val successfulAttempts = args.success
        val unsuccessfulAttempts = args.unsuccess

        binding.textViewResults.text = "Відгадав $successfulAttempts разів, не відгадав $unsuccessfulAttempts разів "


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