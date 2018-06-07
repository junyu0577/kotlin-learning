package com.github.junyu.kotlin.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.junyu.kotlin.R
import com.github.junyu.kotlin.bean.*
import com.github.junyu.kotlin.databinding.ActivityFunctionBinding
import com.github.junyu.kotlin.utils.AndroidUtils

/**
 *
 * sample with dataBinding
 * @author ShaoJunyu
 * @date 2018/6/6 10:40
 *
 */
class FunctionActivity : AppCompatActivity() {

    private val updateMsg = UpdateMsg()

    private lateinit var binding: ActivityFunctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@FunctionActivity, R.layout.activity_function)

        binding.versionMode = updateMsg

        updateMsg.versionCode.set(AndroidUtils.getVersionCode(this@FunctionActivity))
        updateMsg.versionName.set(AndroidUtils.getVersionName(this@FunctionActivity))
        updateMsg.isForceUpdate.set(setIsForceUpdate())
//        updateMsg.device.set(Device(AndroidUtils.sdkVersion,AndroidUtils.androidBoard))
        updateMsg.device.set(Device(AndroidUtils.sdkVersion, AndroidUtils.androidBoard, AndroidUtils.androidBrand))

        setPlatForm("ios")
        setVersionInfo("1.xxx", "2.xxx", "3.xxx")

//        val strArray = arrayOf("1.xxx", "2.xxx", "3.xxx")
//        setVersionInfo(*strArray)
    }

    private fun setPlatForm(platform: String = "android") {
        updateMsg.platForm.set(platform)
    }

    private fun setVersionInfo(vararg str: String) {
        val msg = StringBuilder()
        for (s in str) {
            msg.append("\n \t$s")
        }
        updateMsg.updateInfo.set(msg.toString())
    }

    private fun setIsForceUpdate() = true
}
