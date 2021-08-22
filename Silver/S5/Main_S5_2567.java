package boj;

import java.util.Scanner;

public class Main_S5_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		
		int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int i=0; i<N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			for(int r=R; r<R+10; r++) {
				for(int c=C; c<C+10; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int len = 0;		// 둘레 길이
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map.length; c++) {
				if(map[r][c] == 1) {	// 현재 좌표 값이 1 일때 

					for(int i=0; i<4; i++) {	// 4방 탐색
						int nr = r+d[i][1];
						int nc = c+d[i][0]; 					
						
						if(nr<0 || nr>100 || nc<0 || nc>100 	// 1이면서 가장자리에 있거나
								|| map[nr][nc]==0) {			// 사방에 0이 존재할 경우
							System.out.println(r + ", " + c);
							len++;
						}
					}
				}				
			}
		}
		System.out.println(len);
	}
}
