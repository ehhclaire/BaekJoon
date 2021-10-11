package boj.Silver;
/**
 * nCr = n-1Cr-1 + n-1Cr
 */
import java.io.StringReader;
import java.util.Scanner;

public class Main_S5_1010 {
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase=1; testcase<=T; testcase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] dp = new int[N+1][M+1];
			
			for(int r=0; r<=N; r++) {
				for(int n=0; n<=M; n++) {
					// nCn = nC0 = 0Cn = 1
					if(n==r || r==0 || n==0) dp[r][n] = 1;
					else dp[r][n] = dp[r-1][n-1] + dp[r][n-1];
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}
