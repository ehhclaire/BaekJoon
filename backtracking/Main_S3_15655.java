package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_15655 {

	static int n, r;
	static int[] numbers;
	static int[] inputs;
	static StringBuilder sb;

	private static void combination(int start, int cnt) {
		if(cnt==r) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
			
		for(int i=start; i<n; i++) {
			numbers[cnt] = inputs[i];
			combination(i+1, cnt+1);
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		
		numbers = new int[r];
		inputs = new int[n];
		
		for(int i=0; i<n; i++) {
			inputs[i] = sc.nextInt();
		}
		
		Arrays.sort(inputs);
		
		combination(0, 0);
	}
}
