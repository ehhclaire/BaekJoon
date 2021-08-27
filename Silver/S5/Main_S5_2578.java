package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_2578 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		int[][] map = new int[5][5];
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int bingo = 0;	// 빙고 횟수
		int turn = 0;	// 사회자가 부른 횟수
		
		out:
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());	// 사회자가 부른 번호
				turn++;
				bingo = 0;
				
				// 해당번호를 찾아 0으로 바꾸기
				top:
				for(int r=0; r<5; r++) {
					for(int c=0; c<5; c++) {
						if(map[r][c]==num) {
							map[r][c] = 0;
							break top;
						}
					}
				}
				
				// 행별로 탐색
				for(int r=0; r<5; r++) {
					int cnt = 0;
					for(int c=0; c<5; c++) {
						if(map[r][c]==0) cnt++;
					}
					if(cnt==5) bingo++;		// 한줄에 0이 5개라면 라인 긋기
				}
				
				// 열별로 탐색
				for(int c=0; c<5; c++) {
					int cnt = 0;
					for(int r=0; r<5; r++) {
						if(map[r][c]==0) cnt++;	
					}
					if(cnt==5) bingo++;		// 한줄에 0이 5개라면 라인 긋기
				}
				
				// 왼쪽 사선 탐색
				int cnt = 0;
				if(map[0][0]==0) cnt++;
				if(map[1][1]==0) cnt++;
				if(map[2][2]==0) cnt++;
				if(map[3][3]==0) cnt++;
				if(map[4][4]==0) cnt++;
				if(cnt==5) bingo++;
				
				// 오른쪽 사선 탐색
				cnt = 0;
				if(map[4][0]==0) cnt++;
				if(map[3][1]==0) cnt++;
				if(map[2][2]==0) cnt++;
				if(map[1][3]==0) cnt++;
				if(map[0][4]==0) cnt++;
				if(cnt==5) bingo++;
				
				if(bingo>=3) {
					break out;
				}
			}
		}
		System.out.println(turn);
	}
	static String src = "14 12 5 11 13 \r\n" + 
			"9 4 3 8 25 \r\n" + 
			"18 15 19 24 20 \r\n" + 
			"1 6 7 23 17 \r\n" + 
			"22 16 10 2 21 \r\n" + 
			"17 11 9 24 6 \r\n" + 
			"23 1 2 15 12 \r\n" + 
			"8 14 21 10 16 \r\n" + 
			"3 22 18 13 25 \r\n" + 
			"4 5 19 7 20";
}
