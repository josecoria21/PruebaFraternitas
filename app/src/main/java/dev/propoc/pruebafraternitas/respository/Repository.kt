package dev.propoc.pruebafraternitas.respository

import dev.propoc.pruebafraternitas.model.CategoryJoke
import dev.propoc.pruebafraternitas.network.ApiClient

class Repository {
    private val apiService = ApiClient.apiService

    suspend fun getCategories(): List<String> {
        return apiService.getCategories()
    }

    suspend fun getCategoryJoke(category: String): CategoryJoke {
        return apiService.getCategorieJoke(category)
    }
}