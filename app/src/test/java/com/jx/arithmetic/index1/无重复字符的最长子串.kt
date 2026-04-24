package com.jx.arithmetic.index1

import com.jx.arithmetic.log
import org.junit.Test

/**
 * 给定一个字符串s,请你找出其中不含有重复字符的 最长子串 的长度
 * 例如：
 *      输入：s="abcabcbb"
 *      输出3(abc)
 */
class 无重复字符的最长子串 {
    @Test
    fun main() {
        test("abcabcdbb")
    }

    private fun test(str: String) {
        var max = 0
        var maxStr = ""
        var recordMaxStr = ""
        for (index in str.indices) {
            if (!maxStr.contains(str.get(index))) {
                var old = maxStr
                maxStr = "$maxStr${str.get(index)}"
                log("in ${str.get(index)} from $old to $maxStr")
            } else {
                if (maxStr.length > max) {
                    max = maxStr.length
                    recordMaxStr = maxStr
                }
                var old = maxStr
                maxStr = "${maxStr.substring(maxStr.indexOf(str.get(index)) + 1)}${str.get(index)}"
                log("in ${str.get(index)} from $old to $maxStr")
            }
        }
        if (maxStr.length > max) {
            max = maxStr.length
            recordMaxStr = maxStr
        }
        log("last maxStr=$recordMaxStr length=$max")
    }
}