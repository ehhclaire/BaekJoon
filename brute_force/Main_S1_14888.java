package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S1_14888 {
	static int N, min, max, perm[], numbers[];
	static int[] operator;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		perm = new int[N-1];
		numbers = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		operator = new int[4];	// 연산자 4개 (+, -, *, /)
		
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			operator[i] = sc.nextInt();
		}

		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int cnt) {
		if(cnt == N-1) {
			calculate();
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i]==0) continue;
			
			perm[cnt] = i;
			operator[i]--;
			permutation(cnt+1);
			operator[i]++;
		}
	}

	private static void calculate() {
		int sum = numbers[0];
		for(int i=1; i<N; i++) {
			if(perm[i-1] == 0) sum += numbers[i];
			else if(perm[i-1] == 1) sum -= numbers[i];
			else if(perm[i-1] == 2) sum *= numbers[i];
			else {
				if(sum < 0) {
					sum *= -1;
					sum /= numbers[i];
					sum *= -1;
				} else {
					sum /= numbers[i];
				}
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
	}
}
