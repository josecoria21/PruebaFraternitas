package dev.propoc.pruebafraternitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dev.propoc.pruebafraternitas.databinding.FragmentCategoriesBinding
import dev.propoc.pruebafraternitas.viewmodel.ChuckNorrisViewModel

class CategoriesFragment : Fragment() {


    private val viewModel: ChuckNorrisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCategoriesBinding.inflate(inflater, container, false).apply {
            this.viewModel = this@CategoriesFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        val adapter = CategoriesAdapter()
        binding.reyclerView.adapter = adapter

        viewModel.getCategories()
        viewModel.categories.observe(viewLifecycleOwner) { categoryList ->
            adapter.setData(categoryList.toList())
        }

        return binding.root
    }
}

