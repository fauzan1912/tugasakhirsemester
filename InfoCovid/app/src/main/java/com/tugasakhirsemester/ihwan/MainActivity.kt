package com.tugasakhirsemester.ihwan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugasakhirsemester.ihwan.api.RetrofitClient
import com.tugasakhirsemester.ihwan.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()
    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positif = indonesia?.positif
                val hospitilized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text = positif
                tvHospitalized.text = hospitilized
                tvRecover.text = recover
                tvDeath.text = death

            }
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}