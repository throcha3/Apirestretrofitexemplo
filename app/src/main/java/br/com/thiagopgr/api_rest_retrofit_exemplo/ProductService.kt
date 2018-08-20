package br.com.thiagopgr.api_rest_retrofit_exemplo

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("produtos")
    fun list() : Call<List<Product>>
}