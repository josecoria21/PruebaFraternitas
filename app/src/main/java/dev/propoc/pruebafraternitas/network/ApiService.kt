package dev.propoc.pruebafraternitas.network

import dev.propoc.pruebafraternitas.model.CategoryJoke
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Arrays

interface ApiService {

    @GET("categories")
    suspend fun getCategories(): List<String>

    @GET("random")
    suspend fun getCategorieJoke(@Query("category") category: String?): CategoryJoke

}