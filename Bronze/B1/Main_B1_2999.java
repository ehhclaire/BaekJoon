package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B1_2999 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		
		int R = 0, C = 0;
		for(int r=1; r<=N; r++) {
			for(int c=r; c<=N; c++) {
				if(r*c==N 		// r * c == N 이고
					&& r<=c 	// r <= c 이면서
					&& r>R) {	// 이전의 R보다 현재 r이 더 크다면
					// 새로운 r, c로 갱신
					R = r;		
					C = c;					
				}
			}
		}
		char[][] secret = new char[R][C];	// 해독을 위한 2차원 배열 생성
		int idx = 0;
		
		// 열별로 문자를 입력
		for(int j=0; j<C; j++) {
			for(int i=0; i<R; i++) {
				secret[i][j] = str.charAt(idx++);	
			}
		}
		// 해독한 문자 출력
		for(char[] sec : secret) {
			for(char s : sec) { 
				System.out.print(s);
			}
		}
	}
}
