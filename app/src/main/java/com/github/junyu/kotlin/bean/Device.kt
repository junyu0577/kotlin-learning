package com.github.junyu.kotlin.bean

/**
 *
 * @author ShaoJunyu
 * @since 2018/6/6 10:44
 *
 */
class Device constructor(sdkVersion: Int, androidBoard: String) {

    private var sdkVersion: Int? = null
    private var androidBoard: String? = null

    init {
        this.sdkVersion = sdkVersion
        this.androidBoard = androidBoard
    }

    fun getSdkVersion():Int?{
        return sdkVersion
    }

    fun getAndroidBoard():String?{
        return androidBoard
    }

}