package dev.propoc.pruebafraternitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dev.propoc.pruebafraternitas.databinding.FragmentCategoriesBinding
import dev.propoc.pruebafraternitas.viewmodel.ChuckNorrisViewModel

class CategoriesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCategoriesBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val viewModel: ChuckNorrisViewModel by viewModels()

        val adapter = CategoriesAdapter()
        binding.reyclerView.adapter = adapter

        viewModel.categories.observe(viewLifecycleOwner) { categoryList ->
            adapter.setData(categoryList.toList())
        }

        return binding.root
    }
}
pedro.torres@fraternitas.io
pmpedrotorres@gmail.com

