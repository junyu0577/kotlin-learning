package com.github.junyu.kotlin.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.junyu.kotlin.R
import com.github.junyu.kotlin.databinding.ActivityDelegateBinding
import kotlin.properties.Delegates

class DelegateActivity : AppCompatActivity(){

    private val str: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        "HELLO WORLD"
    }

    private var number: Int by Delegates.vetoable(0) { _, _, new ->
        when (new) {
            20 -> {
                Toast.makeText(this@DelegateActivity, "success", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                Toast.makeText(this@DelegateActivity, "fail the number is $number", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    private val user = User(mutableMapOf(
            "name" to "JunYu",
            "age" to 18
    ))


    var name: String by Delegates.observable("default") { _, old, new ->
        binding.observerTv.text = String.format(getString(R.string.delegate_observer_text), old, new)
    }

    private lateinit var binding: ActivityDelegateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DelegateActivity, R.layout.activity_delegate)
        binding.lazyTv.text = String.format(getString(R.string.delegate_lazy_text), "str: $str")

        setNumber()

        binding.mapTv.text = String.format(getString(R.string.delegate_map_text), user.name, user.age)
    }

    private fun setNumber() {
        binding.numberTv.text = String.format(getString(R.string.delegate_number_text), "$number")
    }

    fun left(v: View) {
        name = "first"
    }

    fun right(v: View) {
        name = "last"
    }

    fun bigger(v: View) {
        number = 20
        setNumber()
    }

    fun smaller(v: View) {
        number = 10
        setNumber()
    }

    class User(map: MutableMap<String, Any?>) {
        var name: String by map
        var age: Int  by map
    }

}
