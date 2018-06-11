package com.github.junyu.kotlin.bean

/**
 * @author ShaoJunyu
 * @since 2018/6/11 16:12
 */
data class Girls(val error: Boolean, val results: ArrayList<Result>) {
    data class Result(val _id: String,val url:String)
}


