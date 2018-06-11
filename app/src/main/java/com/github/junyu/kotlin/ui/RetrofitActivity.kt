package com.github.junyu.kotlin.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.github.junyu.kotlin.R
import com.github.junyu.kotlin.adapter.GirlsAdapter
import com.github.junyu.kotlin.bean.Girls
import com.github.junyu.kotlin.databinding.ActivityRetrofitBinding
import com.github.junyu.kotlin.net.RetrofitManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.properties.Delegates


class RetrofitActivity : BaseActivity() {

    private var binding: ActivityRetrofitBinding by Delegates.notNull()

    private var startTime: Long by Delegates.notNull()
    private val requestTime = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@RetrofitActivity, R.layout.activity_retrofit)

        loadData()
    }

    private fun loadData() {
        startTime = System.currentTimeMillis()
        rxManager.add(Observable.create<Girls> { e ->
            val call = RetrofitManager.service.getGirlList(100, 1)
            val girls = call.execute().body()
            e.onNext(girls)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ result ->

            val girlsAdapter = GirlsAdapter(this,result.results)
            binding.imageRv.layoutManager = GridLayoutManager(this,2)
            binding.imageRv.adapter = girlsAdapter

            dismissLoadView()
        }, { error ->
            dismissLoadView()
            error.printStackTrace()
        }))
    }

    private fun dismissLoadView() {
        val spendTime = System.currentTimeMillis() - startTime
        if (spendTime >= requestTime) {//wait 1s
            binding.viewLoading.loadingView.visibility = View.GONE
        } else {
            Handler().postDelayed({
                binding.viewLoading.loadingView.visibility = View.GONE
            }, (requestTime - spendTime))
        }

    }
}

