package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_15653 {
	static int n;
	static int r;
	static int[] numbers;
	static int[] inputs;
	
	private static void permutation(int cnt, int flag) {
		if(cnt==r) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((flag & 1<<i)!=0) continue;
			
			numbers[cnt] = inputs[i];
			permutation(cnt+1, flag | 1<<i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 입력 개수
		r = sc.nextInt();		// 수열 길이
		
		numbers = new int[r];
		inputs = new int[n];
		
		for(int i=0; i<n; i++) {
			inputs[i] = sc.nextInt();
		}
		
		Arrays.sort(inputs);
		
		permutation(0, 0);
	}	
}
