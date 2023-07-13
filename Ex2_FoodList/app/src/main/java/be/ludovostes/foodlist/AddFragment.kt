package be.ludovostes.foodlist

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import be.ludovostes.foodlist.ListFragment.Companion.PROD_NAME_RESULT
import be.ludovostes.foodlist.ListFragment.Companion.NB_PROD_RESULT
import be.ludovostes.foodlist.ListFragment.Companion.FRAGMENT_RESULT
import be.ludovostes.foodlist.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val nameProd = binding.addProdEditText.text.toString()
            val nbProd = binding.nbProdEditText.text.toString()
            if (nameProd.isNotEmpty() && nbProd.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString(PROD_NAME_RESULT, nameProd)
                bundle.putString(NB_PROD_RESULT, nbProd)
                setFragmentResult(FRAGMENT_RESULT, bundle)
                findNavController().navigateUp()
            }
        }
    }
}