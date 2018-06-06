package com.github.junyu.kotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.junyu.kotlin.bean.Device
import com.github.junyu.kotlin.bean.UpdateMsg
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityFunctionBinding = DataBindingUtil.setContentView(this@FunctionActivity, R.layout.activity_function)

        binding.versionMode = updateMsg

        updateMsg.versionCode.set(AndroidUtils.getVersionCode(this@FunctionActivity))
        updateMsg.versionName.set(AndroidUtils.getVersionName(this@FunctionActivity))
        updateMsg.isForceUpdate.set(setIsForceUpdate())
        updateMsg.device.set(Device(AndroidUtils.sdkVersion,AndroidUtils.androidBoard))

        setPlatForm("ios")
        setVersionInfo("1.xxx","2.xxx","3.xxx")

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


//open class A{
//    open fun foo(i : Int = 10){}
//}
//
//class B : A(){
//    override fun foo(i: Int) {
//        super.foo(i)
//        println(i)
//    }
//}
//
//fun main(args: Array<String>) {
//    B().foo()
//}