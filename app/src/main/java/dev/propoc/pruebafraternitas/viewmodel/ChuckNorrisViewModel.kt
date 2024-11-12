package dev.propoc.pruebafraternitas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.propoc.pruebafraternitas.model.CategoryJoke
import dev.propoc.pruebafraternitas.respository.Repository
import kotlinx.coroutines.launch

class ChuckNorrisViewModel: ViewModel() {

    private val repository = Repository()

    private val _categories = MutableLiveData<List<String>>()
    val categories: LiveData<List<String>> = _categories

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    val categoryJoke = MutableLiveData<CategoryJoke>()

    fun getCategories() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = repository.getCategories()
                _categories.postValue(response)
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