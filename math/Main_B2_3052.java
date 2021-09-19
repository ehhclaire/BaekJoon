package boj;

import java.util.Scanner;

public class Main_B2_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] divide = new int[42];
		
		for(int i=0; i<10; i++) {
			divide[sc.nextInt()%42]++;
		}
		
		int cnt=0;
		for(int i=0; i<42; i++) {
			if(divide[i]>0) cnt++;
		}
		System.out.println(cnt);
	}
}
