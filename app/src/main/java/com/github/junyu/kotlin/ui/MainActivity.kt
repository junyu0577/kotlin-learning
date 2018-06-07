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

    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.basic_btn) {
            startActivity(Intent(this@MainActivity, BasicActivity::class.java))
        }else if (id == R.id.dataBinding_btn) {
            startActivity(Intent(this@MainActivity, FunctionActivity::class.java))
        }else if (id == R.id.delegate_btn) {
            startActivity(Intent(this@MainActivity, DelegateActivity::class.java))
        }
    }
}
