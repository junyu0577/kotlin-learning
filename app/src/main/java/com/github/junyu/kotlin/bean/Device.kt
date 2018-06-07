package com.github.junyu.kotlin.bean

/**
 *
 * @author ShaoJunyu
 * @since 2018/6/6 10:44
 *
 */
class Device constructor(sdkVersion: Int, androidBoard: String) : BaseEntity() {

    private var sdkVersion: Int? = null
    private var androidBoard: String? = null
    private var androidBrand: String? = null

    init {
        this.sdkVersion = sdkVersion
        this.androidBoard = androidBoard
    }

    constructor(sdkVersion: Int, androidBoard: String, androidBrand: String) : this(sdkVersion, androidBoard) {
        this.androidBrand = androidBrand
    }

    fun getSdkVersion(): Int? {
        return sdkVersion
    }

    fun getAndroidBoard(): String? {
        return androidBoard
    }

    fun getAndroidBrand(): String? {
        return androidBrand
    }

}