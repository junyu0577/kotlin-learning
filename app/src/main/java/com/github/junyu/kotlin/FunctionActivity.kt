package com.github.junyu.kotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.junyu.kotlin.bean.UpdateMsg
import com.github.junyu.kotlin.databinding.ActivityFunctionBinding
import com.github.junyu.kotlin.utils.AndroidUtils

class FunctionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding: ActivityFunctionBinding  = DataBindingUtil.setContentView(this@FunctionActivity, R.layout.activity_function)

        val updateMsg = UpdateMsg()
        binding.versionMode = updateMsg

        updateMsg.versionCode.set(AndroidUtils.getVersionCode(this@FunctionActivity))
        updateMsg.versionName.set(AndroidUtils.getVersionName(this@FunctionActivity))

    }


}
