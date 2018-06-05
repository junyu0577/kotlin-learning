package com.github.junyu.kotlin.utils

import android.content.Context
import android.content.pm.PackageManager

/**
 *
 * @author ShaoJunyu
 * @since 2018/6/5 16:58
 *
 */
class AndroidUtils private constructor(){

    init {
        throw Error("Do not need instantiate!")
    }

    companion object {
        fun getVersionCode(context: Context): Int {
            var verCode = -1
            try {
                val packageName = context.packageName
                verCode = context.packageManager
                        .getPackageInfo(packageName, 0).versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return verCode
        }

        fun getVersionName(context: Context): String {
            var verName = ""
            try {
                val packageName = context.packageName
                verName = context.packageManager
                        .getPackageInfo(packageName, 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return verName
        }

    }


}