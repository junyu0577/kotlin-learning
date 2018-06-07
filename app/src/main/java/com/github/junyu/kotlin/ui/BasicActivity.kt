package com.github.junyu.kotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.junyu.kotlin.R


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

        branchOperator()

        //click listener
        addClickListener()

    }

    private fun branchOperator() {
        // use when to replace switch case
        when (1) {
            1 -> println("one")
            2 -> println("two")
            else -> {
                println("three")
            }
        }

        when (7) {
            1, 2, 3 -> println("first")
            4, 5, 6 -> println("second")
            else -> println("third")
        }

        when (7) {
            in 0..10 -> println("一")
            !in 8..10 -> println("二")
            else -> {
                println("零")
            }
        }

        val str = "abc"
        when (str) {
            is String -> println("$str is String")
            !is String -> println("$str is not String")
        }

        when {
            true ->
                println("----------")
            else ->
                println("==========")
        }

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

        val elements = arrayListOf("a", 'b', 3, 3.1f, 3.2)
        for (i in elements) {
            print("$i ")
        }
        println()

        for (i in Array(5, { index -> (index * 3) })) {
            println(i)
        }

        for (j in booleanArrayOf(true, false, true)) {
            println("booleanArray：$j")
        }

        val array = arrayListOf("aa", "bb", "cc", null, "dd")
        for ((index, value) in array.withIndex()) {
            value?.let {//filter null elements
                println("$index -> $value")
            }
        }

        //or iterate over the elements
        val iterator: Iterator<Any?> = array.iterator()
        while (iterator.hasNext()) {
            println("iterate loop: ${iterator.next()}")
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
        println("\$$price")
        println(addNum(3, 3))

        val s = "123"
        println(s.length)
        var s1: String? = null
//        s1 = "44"
        println("s1 length ${s1?.length ?: -1}")
//        println(s1!!.length) //npe

        var str = """<123<456
            < 111 <
            < 222
            < 333
        """.trimMargin()
        println("before: str length is ${str.length}")
//        str = str.trim()
        str = str.trimMargin("<")
        println("after : str length is ${str.length} $str")

        println("   ".isBlank())//true

        val num2 : Int? = 3.5 as? Int  //with ?  the value will be null.Otherwise throw ClassCastException,
        println("nun2 = $num2")
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

    private fun addNum(a: Int, b: Int): String? {
        var result: String? = (a + b).toString()
        return result
    }

}
