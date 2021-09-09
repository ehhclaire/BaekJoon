package boj.Silver;

import java.util.Scanner;

public class Main_S3_15652 {
	static int n, r;
	static int[] numbers;
	static StringBuilder sb;

	private static void combination(int start, int cnt) {
		if(cnt==r) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
			
		for(int i=start; i<=n; i++) {
			numbers[cnt] = i;
			combination(i, cnt+1);
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
