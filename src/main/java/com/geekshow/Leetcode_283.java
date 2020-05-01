package com.geekshow;

public class Leetcode_283 {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });
		moveZeroes2(new int[] { 0, 1, 0, 3, 12 });
		moveZeroes3(new int[] { 0, 1, 0, 3, 12 });
		moveZeroes4(new int[] { 0, 1, 0, 3, 12 });
	}

	public static void moveZeroes(int[] nums) {

		int[] newNums = new int[nums.length];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				newNums[j] = nums[i];
				j++;
			}
		}
		nums = newNums;
	}

	public static void moveZeroes2(int[] nums) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] == 0) {
					nums[j] = nums[j + 1];
					nums[j + 1] = 0;
				}
			}
		}
	}

	public static void moveZeroes3(int[] nums) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count] = nums[i];
				count++;
			}
		}
		for (int i = count; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
	
	public static void moveZeroes4(int[] nums) {

		int count = 0;
		int temp = nums[count];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp = nums[count];
				nums[count] = nums[i];
				nums[i] = temp;
				count++;
			}
		}
	}
}
