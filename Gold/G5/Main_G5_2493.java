package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> top = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 처음 값은 무조건 stack에 넣고 0 출력
		int n = Integer.parseInt(st.nextToken());
		top.push(n);
		index.push(1);
		System.out.print(0);
		
		// 2번째 탑 높이 부터 스택에 저장
		for(int i=1; i<N; i++) {
			n = Integer.parseInt(st.nextToken());	// 다음 탑 높이 받아오기
			
			while(true) {
				if(top.isEmpty()) {		// 스택 안에 비교할 대상이 없다면
					System.out.print(" " + 0);
					top.push(n);		// 현재 탑 높이 stack에 저장
					index.push(i+1);	// 해당 탑 번호 stack에 저장
					break;
				}
				if(top.peek() > n) {	// 이전의 탑이 현재 탑보다 높다면
					System.out.print(" " + index.peek());
					top.push(n);		
					index.push(i+1);
					break;
				} else {				// 이전의 탑이 현재 탑보다 낮다면
					top.pop();			// stack 에서 이전 탑 정보 빼기
					index.pop();	
				}
			}
		}
	}
}
