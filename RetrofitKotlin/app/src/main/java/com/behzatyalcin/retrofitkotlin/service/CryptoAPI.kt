package com.behzatyalcin.retrofitkotlin.service


import com.behzatyalcin.retrofitkotlin.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

       // GET , POST , UPDATE , DELETE

       @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
       fun getData():Observable<List<CryptoModel>>

      // fun getData() :Call<List<CryptoModel>>
}