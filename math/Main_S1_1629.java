package boj.Silver;

import java.util.Scanner;

/*
 * 10^11 = 10^5 * 10^5 * 10;
 * 10^8 = 10^4 * 10^4;
 */

public class Main_S1_1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		// A를 B번 곱한 수를 C로 나눈 나머지
		System.out.println(power(A, B, C));
	}

	private static long power(long a, long b, long c) {
		if(b==1) return a % c;
		
		long pow = power(a, b/2, c) % c;
		
		if(b%2==0) {	// 짝수인 경우
			return (pow * pow) % c;
		} else {	// 홀수인 경우
			return (((pow * pow) % c) * a) % c;
		}
	}
}