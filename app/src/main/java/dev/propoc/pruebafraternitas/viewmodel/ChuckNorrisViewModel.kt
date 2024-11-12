package dev.propoc.pruebafraternitas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.propoc.pruebafraternitas.model.CategoriesModel
import dev.propoc.pruebafraternitas.model.CategoryJoke
import dev.propoc.pruebafraternitas.respository.Repository
import kotlinx.coroutines.launch

class ChuckNorrisViewModel: ViewModel() {

    private val repository = Repository()

    private val _categories = MutableLiveData<Array<CategoriesModel>>()
    val categories: LiveData<Array<CategoriesModel>> = _categories

    val categoryJoke = MutableLiveData<CategoryJoke>()

    fun getCategories() {
        viewModelScope.launch {
            try {
                _categories.value = repository.getCategories()
            } catch (e: Exception) {
                println("Failed to load data: ${e.message}") }
        }
    }

    fun getCategoryJoke(category: String) {
        viewModelScope.launch {
            try {
                categoryJoke.value = repository.getCategoryJoke(category)
            }finally {

            }
        }
    }
}