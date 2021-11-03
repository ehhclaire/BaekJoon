package boj.Gold;

import java.util.Scanner;

/**
 * 
 * N을 만들기위해서 1개, 2개, 3개,....K개를 사용했을경우 나오는 경우의 수를 구하면서 패턴을 찾는다
 * dp[N][K] = dp[N][K-1] + dp[N-1][K];
 *
 */
public class Main_G5_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[N+1][K+1];
		
		for(int k=0; k<=K; k++) {
			dp[0][k] = 1;
		}
		
		for(int n=1; n<=N; n++) {
			for(int k=1; k<=K; k++) {
				dp[n][k] = (dp[n][k-1] + dp[n-1][k])%1000000000;
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=K; j++) {
//				System.out.printf("%3d", dp[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		System.out.println(dp[N][K]);
	}
}
