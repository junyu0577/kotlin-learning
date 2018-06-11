package com.github.junyu.kotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.junyu.kotlin.baserx.RxManager
import kotlin.properties.Delegates

open class BaseActivity : AppCompatActivity() {

    var rxManager: RxManager by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rxManager = RxManager()

    }

    override fun onDestroy() {
        super.onDestroy()
        rxManager.clear()
    }
}
