package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_15650 {
	static int n;
	static int r;
	static int[] numbers;
	
	private static void combination(int start, int cnt) {
		if(cnt==r) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		if(n<r) return;
		
		for(int i=start; i<=n; i++) {
			numbers[cnt] = i;
			combination(i+1, cnt+1);
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		
		numbers = new int[r];
		combination(1, 0);
	}
}
