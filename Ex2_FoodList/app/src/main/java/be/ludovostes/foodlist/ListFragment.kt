package be.ludovostes.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.ludovostes.foodlist.databinding.FragmentListBinding


class ListFragment : Fragment() {

    companion object {
        const val FRAGMENT_RESULT = "FRAGMENT_RESULT"
        const val PROD_NAME_RESULT = "PROD_NAME_RESULT"
        const val NB_PROD_RESULT = "NB_PROD_RESULT"
    }

    private lateinit var binding: FragmentListBinding

    private val personList = mutableListOf<Prod>(
        Prod("Coca-Cola Zéro 1L", "4")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        binding.customToolbar.addButton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }

        setFragmentResultListener(FRAGMENT_RESULT) { key, bundle ->
            val prodName = bundle.getString(PROD_NAME_RESULT) ?: ""
            val nbProd = bundle.getString(NB_PROD_RESULT) ?: ""
            val prod = Prod(prodName, nbProd)
            personList.add(prod)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = ListAdapter(personList)
    }
}