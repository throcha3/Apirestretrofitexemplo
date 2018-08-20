package br.com.thiagopgr.api_rest_retrofit_exemplo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {


    private val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.2.106/lumen/api-produtos/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun productService() = retrofit.create(ProductService::class.java)
}