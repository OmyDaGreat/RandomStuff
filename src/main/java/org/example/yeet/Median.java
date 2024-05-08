package org.example.yeet;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.stream.Stream;

@Log4j2
public class Median { //4 - Median of Two Sorted Arrays

	public static void main(String[] args) {
		log.info(Median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		for (int i = 0; i < nums1.length + nums2.length; i++) {
			nums[i] = i < nums1.length ? nums1[i] : nums2[i - nums1.length];
		}
		Arrays.sort(nums);
		if (nums.length % 2 == 0) {
			return (double) nums[nums.length / 2 - 1] / 2 + (double) nums[nums.length / 2] / 2;
		}
		return nums[nums.length / 2];
	}
}
