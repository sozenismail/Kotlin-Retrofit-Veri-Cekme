package com.ismailsozen.retrofitexample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val infoServiceProvider = InfoServiceProvider()

    lateinit var listViewSonuc:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewSonuc=findViewById(R.id.listViewSonuc)


        infoServiceProvider.getInfoService().getInfo().enqueue(object : Callback<List<Info>> {
            override fun onFailure(call: Call<List<Info>>, t: Throwable) {



            }

            override fun onResponse(call: Call<List<Info>>, response: Response<List<Info>>) {


                var gelenAdet: Int = response.body()?.size!!


                var sonuclar= arrayOfNulls<String>(gelenAdet)

                for (x in 0  until gelenAdet) {
                    // sonuc.setText(response.body()?.get(x)?.title)


                     sonuclar[x] = arrayListOf(response.body()?.get(x)?.title).toString()



                }
                listViewSonuc.adapter =
                    ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, sonuclar)




            }


        })

    }
}


