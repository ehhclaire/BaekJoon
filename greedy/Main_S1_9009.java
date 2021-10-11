package boj.Silver;

import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_S1_9009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(new StringReader(src));
		
		int T = sc.nextInt();	// 테스트 데이터 수
		
		// 피보나치 배열 생성
		int[] fibo = new int[47];
		fibo[1] = 1;
		for(int i=2; i<47; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		StringBuilder sb = new StringBuilder();	// 정답 저장 StringBuilder
		for(int testcase=1; testcase<=T; testcase++) {
			int N = sc.nextInt();	// 테스트 데이터
			Stack<Integer> stack = new Stack<Integer>();
		
			// N이 0이 될때까지 N보다 같거나 작은 값 중 제일 큰 값으로 감소
			while(N>0) {
				for(int i=45; i>0; i--) {
					if(fibo[i]<=N) {
						stack.push(fibo[i]);
						N -= fibo[i];
					}
				}
			}
			
			// 결과 StringBuilder에 저장
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);		// 결과 한번에 출력
	}
	
	static String src = "4\r\n" + 
			"100\r\n" + 
			"200\r\n" + 
			"12345\r\n" + 
			"1003";
}
