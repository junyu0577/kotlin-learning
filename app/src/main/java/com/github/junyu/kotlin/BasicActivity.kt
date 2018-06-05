package com.github.junyu.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

@Suppress("UsePropertyAccessSyntax")
class BasicActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val viewId: Int = v.id
        when (viewId) {
            R.id.click_bt -> Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
            else -> {
            }
        }

//        if (viewId==R.id.click_bt){
//            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
//        }
    }

    private var aVariable: Byte = 2
    private var bVariable: Short = 2
    private var cVariable: Int = 2
    private var dVariable: Float = 2.0f
    private var eVariable: Double = 2.0
    private var fVariable: Long = 2L
    private var gVariable: Char = '2'
    private var hVariable: String = "2"

    private val sb = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        val variables = "$aVariable,$bVariable,$cVariable,$dVariable,$eVariable,$fVariable,$gVariable,$hVariable"
        println(variables)
        sb.append("$variables \n")

        twoNumCompare()

        bitOperator()

        stringTest()

        loopOperator()

        //click listener
        addClickListener()

    }

    private fun loopOperator() {
        //if
        val numA = 1
        if (numA == 2) {
            println("numA == $numA is true")
        } else {
            println("numA == $numA is false")
        }

        val intA: Int = if (numA >= 2) 2 else 1
        println("intA：$intA")

        for (i in 0 until 5) {//0-4
            println("i =  $i")
        }

        for (j in 0..5) {//0-5
            println("j =  $j")
        }

        for (i in 4 downTo 0) {//4-0
            println(i)
        }

        for (i in 4 downTo 0 step 2) {//4 2 0
            println(i)
        }

//        for (i in "hello world"){
//            println("i: $i")
//        }

        val array = arrayListOf("aa", "bb", "cc")
        for ((index, value) in array.withIndex()) {
            println("$index -> $value")
        }

        //arrayList
        val list = ArrayList<String>()
        list.add("00")
        list.add("11")
        list.add("22")

        for (i in list.indices) {
            println("index = $i and element is ${list[i]}")
        }

    }

    private fun stringTest() {
        val price = "9.99"
        println("$$price")
        println(addNum(3, 3))

        var s = "123"
        println(s.length)
        var s1: String? = null
        println(s1?.length)
//        println(s1!!.length) //npe
    }


    private fun bitOperator() {
        val x = 1 shl 4
        val shlResult = "1 << 4: $x"

        println(shlResult)
        sb.append("\n $shlResult \n")

        val shrResult = "16 >> 4: ${x shr (4)} \n"
        sb.append(shrResult)

        sb.append("3 & 3 ${3 and 3} \n")//0&0=0;   0&1=0;   1&0=0;    1&1=1
        sb.append("3 | 9 ${3 or 9} \n")//0|0=0;   0|1=1;   1|0=1;    1|1=1
        sb.append("3 ^ 9 ${3 xor 9} \n")//0^0=0;   0^1=1;   1^0=1;   1^1=0
        sb.append("4 ~  ${4.inv()} \n")

    }

    private fun addClickListener() {
        val testTv = findViewById<TextView>(R.id.test_tv)
        findViewById<Button>(R.id.next_bt).setOnClickListener {
            Toast.makeText(this@BasicActivity, "redirect", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.click_bt).setOnClickListener(this)

        val text = """
for (c in s) {
    print(c)
}"""

        println(text)
        sb.append("$text \n")

        testTv.setText(sb.toString())
    }

    private fun twoNumCompare() {
        val a: Int = 211
        val b: Int? = a
        var result = a == b
        println("a==b:" + result)

        sb.append("a==b: $result \n")

        result = a === b
        println("a===b:" + result) //when  -128 ~ 127 is true ,otherwise false

        sb.append("a===b: $result \n")
    }

    private fun addNum(a: Int, b: Int): String {
        return (a + b).toString()
    }

}
