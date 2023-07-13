package be.ludovostes.foodlist

import androidx.recyclerview.widget.RecyclerView
import be.ludovostes.foodlist.databinding.ListRowBinding

class ListViewHolder(private val binding: ListRowBinding): RecyclerView.ViewHolder(binding.root) {

    fun setup(prod: Prod) {
        binding.prodName.text = prod.nameProd
        binding.nb.text = prod.nbProd
    }
}
