package be.ludovostes.foodlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.ludovostes.foodlist.databinding.ListRowBinding

class ListAdapter(private val personList: List<Prod>): RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.setup(personList[position])
    }

}