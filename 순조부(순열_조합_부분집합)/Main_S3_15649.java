package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_15649 {

	static int n;
	static int r;
	static int[] numbers;
	static boolean[] visited;
	
	// 일반 수열
//	private static void permutation(int cnt) {
//		if(cnt==r) {
//			for(int num : numbers) {
//				System.out.print(num + " ");
//			}
//			System.out.println();
//			return;
//		}
//		
//		for(int i=0; i<n; i++) {
//			if(visited[i]) continue;
//			
//			numbers[cnt] = i+1;
//			visited[i] = true;
//			permutation(cnt+1);
//			visited[i] = false;
//		}
//	}
	
	// 비트연산자를 이용한 수열
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
			
			numbers[cnt] = i+1;
			permutation(cnt+1, flag | 1<<i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 입력 개수
		r = sc.nextInt();		// 수열 길이
		
		numbers = new int[r];
		visited = new boolean[n];
		
//		permutation(0);
		permutation(0, 0);
	}	
}
