package dev.propoc.pruebafraternitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.propoc.pruebafraternitas.databinding.CategoriesViewBinding

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.DataViewHolder>() {
    private var items = listOf<String>()

    fun setData(data: List<String>) {
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = CategoriesViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class DataViewHolder(private val binding: CategoriesViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.categoriesName.text = item
            binding.executePendingBindings()
        }
    }
}