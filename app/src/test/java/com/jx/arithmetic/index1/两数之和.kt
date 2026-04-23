package com.jx.arithmetic.index1

import androidx.annotation.IntegerRes
import com.jx.arithmetic.log
import org.junit.Test

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 */
class 两数之和 {
    @Test
    fun main() {
        log("两数之和")
        test(intArrayOf(2, 7, 5, 6, 7), 9)
    }

    private fun test(nums: IntArray, target: Int) {
        var hashMap = HashMap<Int, Int>()
        for (index in nums.indices) {
            if (hashMap.containsKey(target - nums[index])) {
                log(
                    "$target=${target - nums[index]}(index${hashMap[target - nums[index]]})" +
                            "+${nums[index]}(index$index)"
                )
                return
            } else {
                hashMap[nums[index]] = index
            }
        }
    }
}