package br.com.thiagopgr.api_rest_retrofit_exemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = RetrofitInitializer().productService().list()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>?>?,
                                    response: Response<List<Product>?>?) {
                response?.body()?.let {
                    Log.e("teste", it.toString())
                    val products: List<Product> = it
                    configureList(products)
                }
            }

            override fun onFailure(call: Call<List<Product>?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    private fun configureList(products: List<Product>) {

        val adapter = ArrayAdapter(this,
                R.layout.row_list, products)

        val listView:ListView = findViewById(R.id.listItens)
        listView.adapter = adapter

    }
}
