package dev.propoc.pruebafraternitas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.propoc.pruebafraternitas.model.CategoryJoke
import dev.propoc.pruebafraternitas.respository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChuckNorrisViewModel: ViewModel() {

    private val repository = Repository()

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    val categoryJoke = MutableStateFlow<CategoryJoke?>(null)

    fun getCategories() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = repository.getCategories()
                _categories.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
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