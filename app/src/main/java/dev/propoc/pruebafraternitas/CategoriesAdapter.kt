package dev.propoc.pruebafraternitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.propoc.pruebafraternitas.databinding.CategoriesViewBinding
import dev.propoc.pruebafraternitas.model.CategoriesModel

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.DataViewHolder>() {
    private var items = listOf<CategoriesModel>()

    fun setData(data: List<CategoriesModel>) {
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
        fun bind(item: CategoriesModel) {
            binding.categoriesName.text = item.categories
            binding.executePendingBindings()
        }
    }
}