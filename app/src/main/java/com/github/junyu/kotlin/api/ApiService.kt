package com.github.junyu.kotlin.api

import com.github.junyu.kotlin.bean.Girls
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 *
 * @author ShaoJunyu
 * @date 2018/6/11 16:09
 *
 */
interface ApiService {

    /**
     * 妹子福利
     */
    @GET("/api/data/福利/{size}/{page}")
    fun getGirlList(
            @Path("size") size: Int,
            @Path("page") page: Int): Call<Girls>
}