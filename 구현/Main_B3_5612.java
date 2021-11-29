package boj.Bronze;

import java.util.Scanner;

public class Main_B3_5612 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int num = sc.nextInt();
		int max = num;
		
		for(int i=0; i<time; i++) {
			num += sc.nextInt();
			num -= sc.nextInt();
			if(num<0) {
				max=0; 
				break;
			}
			max = Math.max(max, num);
		}
		System.out.println(max);
	}

}
