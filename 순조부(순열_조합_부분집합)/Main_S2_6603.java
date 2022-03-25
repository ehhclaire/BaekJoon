package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S2_6603 {
	static int[] numbers;
	static int[] inputs;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N==0) break;
			
			inputs = new int[N];
			numbers = new int[6];
			
			for(int i=0; i<N; i++) {
				inputs[i] = sc.nextInt();
			}
			
			Arrays.sort(inputs);
			
			combination(0, 0);
			System.out.println();
		}
	}

	private static void combination(int cnt, int start) {
		if(cnt==6) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = inputs[i];
			combination(cnt+1, i+1);
		}
	}
}
