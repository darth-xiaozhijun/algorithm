package com.geekshow;

public class Leetcode_167 {

	public static void main(String[] args) {
//		int[] twoSum = twoSum(new int[] { 1, 2, 3, 4, 4, 9, 56, 90 }, 8);
//		int[] twoSum = twoSum2(new int[] { 1, 2, 3, 4, 4, 9, 56, 90 }, 8);
		int[] twoSum = twoSum3(new int[] { 1, 2, 3, 4, 4, 9, 56, 90 }, 8);
		for (int i = 0; i < twoSum.length; i++) {
			System.out.println(twoSum[i]);
		}
	}

	/**
	 * 暴力解法 超时 时间复杂度O(n^2)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 1; j < numbers.length; j++) {
				if (i != j && numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return null;
	}

	/**
	 * 暴力 + 二分查找 时间复杂度O(nlogn)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int low = i + 1;
			int high = numbers.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (numbers[i] + numbers[mid] == target) {
					return new int[] { i + 1, mid + 1 };
				} else if (numbers[i] + numbers[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return null;
	}

	/**
	 * 双指针对撞解法 时间复杂度O(n)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum3(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			if (numbers[low] + numbers[high] == target) {
				return new int[] { low + 1, high + 1 };
			} else if (numbers[low] + numbers[high] > target) {
				high--;
			} else {
				low++;
			}
		}
		return null;
	}
}
