package com.jx.arithmetic.index1

import com.jx.arithmetic.log
import org.junit.Test

/**
 * 给你两个非空的链表，表示两个非负的整数。他们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位的数字
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 * 例如：
 *      2->4->3
 *      5->6->4
 *      -------
 *      7->0->8
 *      343+465=807
 */
class 两数相加 {
    @Test
    fun main() {
        log("两数相加")
        test(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4))
    }

    private fun test(list1: IntArray, list2: IntArray) {
        val list3 = Array<Int?>(Math.max(list1.size, list2.size) + 1) { null }
        var index = 0
        var carry = 0
        while (index < list1.size || index < list2.size) {
            var sum = ((if (index < list1.size) list1[index] else 0) +
                    (if (index < list2.size) list2[index] else 0))
            list3[index] = sum % 10 + carry
            carry = sum / 10
            index++
        }
        if (carry > 0) {
            list3[index] = carry
        }
        for (i in list3) {
            print("${i ?: ""} ")
        }
    }
}