package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
	
		int N = Integer.parseInt(br.readLine());	// 입력 수 개수
		
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 숫자들 입력받기
		
		dp[0] = Integer.parseInt(st.nextToken());	// dp 저장 배열
		int max = dp[0];		// 출력할 최대 값, 첫번째 입력 수로 초기화
		for(int i=1; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(input, input+dp[i-1]);	// (이전 누적합 + 입력값)과 (입력값)을 비교하여 더 큰 수를 저장
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	static String src = "10\r\n" + 
			"10 -4 3 1 5 6 -35 12 21 -1";
}
