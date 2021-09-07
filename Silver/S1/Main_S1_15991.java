package boj.Silver;

import java.io.StringReader;
import java.util.Scanner;

public class Main_S1_15991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(new StringReader(src));
		
		int T = sc.nextInt();
		
		long[] dp = new long[100001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		
		for(int testcase=1; testcase<=T; testcase++) {
			int num = sc.nextInt();
			for(int i=7; i<=num; i++) {
				dp[i] = (dp[i-6] + dp[i-4] + dp[i-2]) % 1000000009;
			}
			System.out.println(dp[num]);
		}
	}
	static String src = "3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";
}
