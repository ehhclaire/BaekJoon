package boj.Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_G3_2437 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] number = new int[N];
		for(int i=0; i<N; i++) {
			number[i] = sc.nextInt();
		}
		
		Arrays.sort(number);
		
		if(number[0]>1) {
			System.out.println(1);
			return;
		}
		
		int num = number[0];	
		for(int i=0; i<N; i++) {
			if(num<number[i]) break;
			num += number[i];
		}
		System.out.println(num);
	}
}
