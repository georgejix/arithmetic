package com.jx.arithmetic.index1

import com.jx.arithmetic.log
import org.junit.Test
import kotlin.math.max
import kotlin.math.min

/**
 * 给定两个大小分别为m和n的正序(从小到大)数组nums1和nums2。
 * 请你找出并返回这两个正序数组的中位数
 *
 * 算法的时间复杂度应该为O(log(m+n))
 *
 */
class 寻找两个正序数组的中位数 {
    @Test
    fun main() {
        val ret = test(intArrayOf(3, 4, 7, 8, 9, 10, 12, 44), intArrayOf(5, 6, 7))
        log("$ret")
    }

    private fun test(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            return test(nums2, nums1)
        }

        val m = nums1.size
        val n = nums2.size

        var left = 0
        var right = m

        while (left <= right) {
            val i = (left + right) / 2
            val j = (m + n + 1) / 2 - i

            val maxLeft1 = if ((i == 0)) Int.MIN_VALUE else nums1[i - 1]
            val minRight1 = if ((i == m)) Int.MAX_VALUE else nums1[i]

            val maxLeft2 = if ((j == 0)) Int.MIN_VALUE else nums2[j - 1]
            val minRight2 = if ((j == n)) Int.MAX_VALUE else nums2[j]

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                return if ((m + n) % 2 == 0) {
                    (max(maxLeft1.toDouble(), maxLeft2.toDouble()) + min(
                        minRight1.toDouble(),
                        minRight2.toDouble()
                    )) / 2.0
                } else {
                    max(maxLeft1.toDouble(), maxLeft2.toDouble())
                }
            } else if (maxLeft1 > minRight2) {
                right = i - 1
            } else {
                left = i + 1
            }
        }
        return 0.0
    }
}