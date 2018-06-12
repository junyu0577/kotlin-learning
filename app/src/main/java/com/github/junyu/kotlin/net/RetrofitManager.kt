package com.github.junyu.kotlin.net

import com.github.junyu.kotlin.api.ApiService
import com.github.junyu.kotlin.api.UriConstant
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
*
*
* @author ShaoJunyu
* @date 2018/6/11 16:31
*
*/
object RetrofitManager{

    private var client: OkHttpClient? = null
    private var retrofit: Retrofit? = null

    val service: ApiService by lazy { getRetrofit()!!.create(ApiService::class.java)}

    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitManager::class.java) {
                if (retrofit == null) {

                    client = OkHttpClient.Builder()
                            .connectTimeout(30L, TimeUnit.SECONDS)
                            .readTimeout(30L, TimeUnit.SECONDS)
                            .writeTimeout(30L, TimeUnit.SECONDS)
                            .build()

                    retrofit = Retrofit.Builder()
                            .baseUrl(UriConstant.BASE_URL)
                            .client(client!!)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }


}
