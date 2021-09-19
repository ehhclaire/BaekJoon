package boj.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1_3985 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());	// 롤 케이크 길이
		int N = Integer.parseInt(br.readLine());	// 방청객 수
		
		int[] rollCake = new int[L+1];
		
		int expect_num = 0;
		int expect = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 제일 많이 받을 것으로 기대되는 사람 번호 구하기
			if(expect<(end-start)) {
				expect_num = i;
				expect = end-start;
			}
			
			for(int j=start; j<=end; j++) {
				if(rollCake[j]==0) {	// 아직 롤케익이 할당되지 않았으면
					rollCake[j] = i;	// 종이에 적힌 범위만큼 배열 값을 방청객 번호로 갱신
				}
			}
		}
		
		// 배열은 탐색하며 각각의 방청객 번호별 케익수 체크
		int real_num = 0;
		int real = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<L+1; j++) {
				if(rollCake[j]==i) cnt++;
			}
			
			// 실제로 제일 많이 받은 방청객 번호 구하기
			if(real<cnt) {
				real_num = i;
				real = cnt;
			}
		}
		System.out.println(expect_num);
		System.out.println(real_num);
	}
}
