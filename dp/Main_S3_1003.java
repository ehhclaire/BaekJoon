package boj.Silver;

import java.util.Scanner;

public class Main_S3_1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트케이스 수
		
		for(int testcase=0; testcase<T; testcase++) {
			int N = sc.nextInt();	// 입력 정수
			
			int[][] fibo = new int[N+1][2];
			
			for(int i=0; i<=N; i++) {
				if(i==0) {
					fibo[i][0] = 1;
					fibo[i][1] = 0;
				} else if(i==1) {
					fibo[i][0] = 0;
					fibo[i][1] = 1;
				} else {
					fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
					fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
				}
			}
			System.out.println(fibo[N][0] + " " + fibo[N][1]);
		}
	}
}
