package boj.Silver;

import java.util.Scanner;

public class Main_S5_14916 {
	public static void main(String[] args) {
		// 1. 풀이 1
//		Scanner sc = new Scanner(System.in);
//		int money = sc.nextInt();
//		int[] D = new int[money+1];
//		
//		D[0] = 0;
//		D[1] = 0;
//		if(money==1) {
//			System.out.println(-1);
//		}
//		
//		for(int i=2; i<=money; i++) {
//			int min = Integer.MAX_VALUE;
//			
//			if(i>=2 && D[i-1]+1<min) min = D[i-1]+1;
//			if(i>=4 && D[i-4]+1<min) min = D[i-4]+1;
//
//			D[i] = min;
//		}
		
		
		
		// 2. 풀이 2
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] change = new int[money+1];
		
		
		for(int i=1; i<=money; i++) {
			if(i==1 || i==3) change[i] = -1;
			else if(i==2 || i==4) change[i] = i/2;
			else if(i==5) change[i] = 1;
			else if(i==6) change[i] = 3;
			else if(i==7) change[i] = 2;
			else if(i==8) change[i] = 4;
			else {
				change[i] = change[i-5] + 1;
			}
		}
		
		System.out.println(change[money]);
	}
}
