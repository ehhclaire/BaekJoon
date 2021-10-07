package boj.Silver;

import java.util.Scanner;

public class Main_S1_16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();	// 출발 정수
		String B = sc.next();	// 완성 정수
				
		int cnt = 0;	// 연산 횟수
		
		int a = Integer.parseInt(A);
		while(true) {
			cnt++;

			int b = Integer.parseInt(B);
			
			if(B.equals(A)) break;
			if(a>b) {
				cnt = -1;
				break;
			}
			
			if(B.charAt(B.length()-1)=='1') {	// 마지막 자리가 1이면
				B = B.substring(0, B.length()-1);
			} else if(b%2==1) {	// 홀수인 경우
				cnt=-1;
				break;
			} else {	// 짝수인 경우
				b /= 2;
				B = Integer.toString(b);
			}
		}
		System.out.println(cnt);	
	}
}
