package boj.Silver;

import java.util.Scanner;

public class Main_S3_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		long[] D = new long[N+1];
	
		for(int i=1; i<=N; i++) {
			if(i==1) {		// 1인 경우, 나눌 횟수 0
				D[i] = 0;
				continue;
			}
			if(i==2 || i==3) {	// 2나 3인 경우, 각각의 수로 1번 나눠야하기 때문에 나눌 횟수 0
				D[i] = 1;
				continue;
			}
			D[i] = D[i-1]+1;	// 4이상의 숫자인 경우, 이전 값 + 1한 값으로 초기화
			if(i%2==0) D[i] = Math.min(D[i], D[i/2]+1);		// 2로 나눠지는 경우 현재 초기값과 2로 나눈횟수 중 최소값을 저장
			if(i%3==0) D[i] = Math.min(D[i], D[i/3]+1);		// 3로 나눠지는 경우 현재 초기값과 3로 나눈횟수 중 최소값을 저장
		}
		System.out.println(D[N]);
	}
}
