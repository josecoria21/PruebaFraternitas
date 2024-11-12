package dev.propoc.pruebafraternitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dev.propoc.pruebafraternitas.databinding.FragmentCategoriesBinding
import dev.propoc.pruebafraternitas.viewmodel.ChuckNorrisViewModel
import kotlinx.coroutines.launch

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
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categories.collect { categoryList ->
                adapter.setData(categoryList)
            }
        }
        viewModel.getCategories()

        return binding.root
    }
}

