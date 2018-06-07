package com.github.junyu.kotlin.bean

/**
 *
 * @author ShaoJunyu
 * @since 2018/6/6 13:58
 *
 */
open class BaseEntity {

    private var code: String? = null
    private var desc: String? = null

    open fun getDesc(): String? {
        return desc
    }

    open fun setDesc(value: String) {
        this.desc = desc
    }

    open fun getCode(): String? {
        return code
    }

    open fun setCode(value: String) {
        this.code = value
    }
}

