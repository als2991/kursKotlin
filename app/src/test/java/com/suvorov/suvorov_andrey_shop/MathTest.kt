package com.suvorov.suvorov_andrey_shop

import org.junit.Assert.assertEquals
import org.junit.Test

class MathTest{

    @Test
    fun  main(){
        var i = 1
        i += 1
        val a = 1 + i
        assertEquals(2,i)
        println("$i $a")
    }
}