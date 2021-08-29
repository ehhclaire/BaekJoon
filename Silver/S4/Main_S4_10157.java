package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S4_10157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] turn = {{1,0},{0,1},{-1,0},{0,-1}};	// 하, 우, 상, 좌
		
		int C = Integer.parseInt(st.nextToken());	// 행 수
		int R = Integer.parseInt(st.nextToken());	// 열 수
		
		int N = Integer.parseInt(br.readLine());	// 관객 대기번호
		int[][] map = new int[R][C];
		
		int num = 1;			// 숫자 1 ~ N
		int r = 0, c = 0;		// 시작 위치
		int t = 0;				// 방향 전환 인덱스
		map[r][c] = num;
		
		if(R*C<N) {
			System.out.println(0);
			return;
		}
		
		while(true) {
			if(num==N) {
				System.out.println((c+1)+" "+(r+1));
				break;
			}
			
			// 전진할 다음 좌표
			int nr = r + turn[t][0];	
			int nc = c + turn[t][1];
			if((nr>-1 && nr<R && nc>-1 && nc<C) // 경계 내에 있고
					&& map[nr][nc]==0) {			// 다음 값이 0 이라면
			} else {
				t = (t+1)%4;
				nr = r + turn[t][0];
				nc = c + turn[t][1];
			}
			map[nr][nc] = ++num;
			r = nr;
			c = nc;
		}
	}
	static String src = "7 6\r\n" + 
			"11";
}
