package com.geekshow;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_75 {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 0, 2, 1, 1, 0, 2, 1 };
		sortColors3(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public void sortColors(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.get(i) == null) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				nums[count] = entry.getKey();
				count++;
			}
		}
	}

	public void sortColors2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	public static void sortColors3(int[] nums) {
		int zero = -1;
		int two = nums.length;
		for (int i = 0; i < two;) {
			if (nums[i] == 1) {
				i++;
			} else if (nums[i] == 2) {
				two--;
				int temp = nums[i];
				nums[i] = nums[two];
				nums[two] = temp;
			} else if (nums[i] == 0) {
				zero++;
				int temp = nums[i];
				nums[i] = nums[zero];
				nums[zero] = temp;
				i++;
			}
		}
	}
}
