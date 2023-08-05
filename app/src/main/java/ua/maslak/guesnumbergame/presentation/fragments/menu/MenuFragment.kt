package ua.maslak.guesnumbergame.presentation.fragments.menu

import androidx.navigation.fragment.findNavController
import ua.maslak.guesnumbergame.databinding.FragmentMenuBinding
import ua.maslak.guesnumbergame.presentation.fragments.BaseFragment

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    override fun setListeners() {
        binding.buttonStart.setOnClickListener {
            val directions = MenuFragmentDirections.actionMenuFragmentToGameFragment()
            findNavController().navigate(directions)
        }

        binding.buttonExit.setOnClickListener {
            requireActivity().finishAndRemoveTask()
        }
    }
}