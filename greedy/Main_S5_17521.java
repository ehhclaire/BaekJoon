package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_17521 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 요일 수 
		long W = Integer.parseInt(st.nextToken());	// 초기 현금
		
		long[] values = new long[N];	// 코인 가치 입력값
		for(int i=0; i<N; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
		long min = values[0];
		for(int i=1; i<N; i++) {
			if(values[i-1]<values[i]) continue;
			else {
				long coins = W / min;	// 매수 코인 개수
				long left = W % min;		// 매수하고 남은 현금
				W = coins * values[i-1] + left;		// 매도한 현금
				while(i<N && values[i-1]>=values[i]) {	// 거래 후, 배열 범위안에 들면서 다음 최소점을 찾을때까지
					i++;
				}
				min = values[i-1];
			}
			
		}
		// 탐색 종료 후, 마지막 요일의 값이 최저 코인 값보다 컸다면
		if(values[N-1]>min) {
			long coins = W / min;	// 매수 코인 개수
			long left = W % min;		// 매수하고 남은 현금
			W = coins * values[N-1] + left;		// 매도한 현금
		}
		System.out.println(W);
	}
	static String src = "10 24\r\n" + 
			"5\r\n" + 
			"7\r\n" + 
			"5\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"5\r\n" + 
			"3\r\n" + 
			"4";
}
