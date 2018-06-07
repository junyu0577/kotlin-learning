package com.github.junyu.kotlin

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates


class BaseApplication : Application() {

    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this@BaseApplication
    }
}
