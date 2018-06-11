package com.github.junyu.kotlin.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.junyu.kotlin.R
import com.github.junyu.kotlin.databinding.ActivityRetrofitBinding
import com.github.junyu.kotlin.net.RetrofitManager
import kotlin.properties.Delegates
import kotlin.concurrent.thread


class RetrofitActivity : AppCompatActivity() {

    private var binding: ActivityRetrofitBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@RetrofitActivity, R.layout.activity_retrofit)
//        binding.viewLoading.loadingView.visibility = View.GONE


        thread { kotlin.run {

            val call  = RetrofitManager.service.getGirlList(10,1)
            val responese = call.execute().body()

        } }


    }
}
