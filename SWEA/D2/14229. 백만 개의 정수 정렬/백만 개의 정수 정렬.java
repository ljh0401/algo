import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] can = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			can[i] = sc.nextInt();
		}
		quikSort(can, 0, 1000000-1);
		System.out.print(can[500000]);
	}
	public static void quikSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			if (pivot == left) {
				pivot += 1;
				quikSort(arr, pivot , right);
			}
			else {
				quikSort(arr, left, pivot - 1);
				quikSort(arr, pivot , right);
			}
		}	
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int L = left+1;
		int R = right;
		while(L <= R) {
			while(L <= R && arr[L] <= pivot) L++;
			while(arr[R] > pivot) R--;
			if (L < R) {
				swap(arr, L, R);
			}
		}
		swap(arr, left, R);
		return R;
	}
	
	public static void swap(int[]arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}
}