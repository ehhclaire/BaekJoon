package boj.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_2669 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());	// 왼쪽 모서리 r 좌표
			int sc = Integer.parseInt(st.nextToken());	// 왼쪽 모서리 c 좌표
			int er = Integer.parseInt(st.nextToken());	// 오른쪽 모서리 r 좌표
			int ec = Integer.parseInt(st.nextToken());	// 오른쪽 모서리 c 좌표
			for(int r=sr; r<er; r++) {
				for(int c=sc; c<ec; c++) {
					map[r][c] = 1;	// 위에 입력받은 범위에 해당하는 자리 1
				}
			}
		}
		int cnt = 0;
		for(int[] ma : map) {
			for(int m : ma) {
				if(m==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
