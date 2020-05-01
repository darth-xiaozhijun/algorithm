package com.geekshow;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 1, 3, 8, 9, 10, 12 }, 8));
	}

	/**
	 * 二分查找 非递归
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int binarySearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找 考虑到整型溢出
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int binarySearch2(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
