package simple;

/*
 * 	认识时间复杂度
 * 	
 * 	常数时间的操作
	
	一个操作如果和样本的数据量没有关系，每次都是固定时间内完成的操作，叫做常数操作。
	
	时间复杂度为一个算法流程中，常数操作数量的一个指标。常用0(读作big 0)来表示。
	具体来说，先要对一个算法流程非常熟悉，然后去写出这个算法流程中，发生了多少常数操作，进而总结出常数操作数量的表达式。

	在表达式中，只要高阶项，不要低阶项，也不要高阶项的系数，剩下的部分如果为f(N)，那么时间复杂度为0(f(N))。

	评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是“常数项时间”。

 */

public class day01 {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// 如果在内存中，i 和 j 是相同的区域，那么会出错
	public static void swap2(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * 	选择排序，冒泡排序细节的讲解与复杂度分析
	 * 
	 * 	时间复杂度 O(N^2) ，额外空间复杂度 O(1)
	 */
	public static void selectionSort(int[] arr) {
		if(arr == null || arr.length <2) {
			return;
		}
		
		for(int i=0; i<arr.length - 1; i++) {
			int minIndex = i;
			for(int j = i+1; j<arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i ,minIndex);
		}
	}
	
	public static void bubbleSort(int[] arr) {
		 if(arr == null || arr.length < 2) {
			 return;
		 }
		 
		 for(int e = arr.length - 1; e > 0; e--) {
			 for(int i = 0; i < e; i++) {
				 if(arr[i] > arr[i+1]) {
					 swap(arr, i, i+1);
				 }
			 }
		 }
	}
	
	/*	
	 * 	例题
	 * 	
	 * 	在一个数组中，有两种数出现了奇数次，其他的数出现了偶数次
	 * 	
	 * 	找出并打印出现了奇数次的两个数
	 */
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for(int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		
		// eor = a ^ b
		// eor != 0
		// eor必然有一个位置上是 1
		
		
		// 提取出最右的 1
		int rightOne = eor & (~eor + 1);
		
		int onlyOne = 0;
		for(int cur : arr) {
			if((cur & rightOne) == 0) {
				onlyOne ^= cur;
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}
	
	
	/* 
	 * 	插入排序细节的讲解与复杂度分析
	 * 
	 * 	时间复杂度O(N^2)，额外空间复杂度O(1)
	 * 
	 * 	算法流程按照最差情况来估计时间复杂度
	 */
	public static void insertionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
				swap(arr, j, j+1);
			}
		}
	}
	
	/*
	 * 	二分法的详解与拓展
	 * 
	 * 	1、在一个有序数组中，找某个数是否存在
	 * 
	 * 	2、在一个有序数组中，找 >= 某个数最左侧的位置
	 * 
	 * 	3、局部最小值问题
	 * 
	 */
	
	
	/*
	 * 	自己编写一个对数器
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		
		// Math.random( ) ->[0,1)所有的小数，等概率返回一个
		// Math.random( )* N -> [0,N)所有小数，等概率返回一个
		// (int)(Math.random() * N) -> [0,N-1]所有的整数，等概率返回一个
		
		// 长度随机
		int[] arr = new int[(int)((maxSize + 1) * Math.random())];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)((maxValue + 1) * Math.random() - (int)(maxValue * Math.random()));
		}
		return arr;
	}
	
	public static void mainTest() {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		
		for(int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			//int[] arr2 = copyArray(arr1);
			// 成熟算法排序 arr1
			insertionSort(arr1);
			// 对数器方法排序 arr2
			//comparator(arr2);
			
//			if(!isEqual(arr1, arr2)) {
//				succeed = false;
//				break;
//			}
		
			System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		}
		
	}
	
	
}
