package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_5557 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][21];	// 0 ~ 20 사이의 숫자의 개수를 저장
		dp[0][num[0]]++;		// 첫번째 정수의 개수 1 증가
		
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]>0) {
					// 합한 경우 20 이하이면, 해당 정수에 누적 개수로 갱신
					if(j+num[i] <= 20) dp[i][j+num[i]] += dp[i-1][j];
					// 감소한 경우 0 이상이면, 해당 정수에 누적 개수로 갱신
					if(j-num[i] >= 0) dp[i][j-num[i]] += dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-2][num[N-1]]);
	}
	static String src = "11\r\n" + 
			"8 3 2 4 8 7 2 4 0 8 8";
}
