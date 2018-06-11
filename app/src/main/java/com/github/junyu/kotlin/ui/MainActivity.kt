package com.github.junyu.kotlin.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.junyu.kotlin.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.basic_btn).setOnClickListener(this)
        findViewById<View>(R.id.dataBinding_btn).setOnClickListener(this)
        findViewById<View>(R.id.delegate_btn).setOnClickListener(this)
        findViewById<View>(R.id.retrofit_btn).setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.basic_btn -> startActivity(Intent(this@MainActivity, BasicActivity::class.java))
            R.id.dataBinding_btn -> startActivity(Intent(this@MainActivity, DataBindingActivity::class.java))
            R.id.delegate_btn -> startActivity(Intent(this@MainActivity, DelegateActivity::class.java))
            R.id.retrofit_btn -> startActivity(Intent(this@MainActivity, RetrofitActivity::class.java))
        }
    }
}
