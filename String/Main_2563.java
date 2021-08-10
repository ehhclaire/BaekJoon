package BOJ;

import java.util.Scanner;

public class Main_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];	// 도화지
		int N = sc.nextInt();	// 색종이 수
		int area;	// 구할 면적
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();	// 색종이 x좌표
			int y = sc.nextInt();	// 색종이 y좌표
			for(int ix=x; ix<x+10; ix++) {	// 입력받은 좌표로부터 색종이 크기 범위만큼(10x10)
				for(int iy=y; iy<y+10; iy++) {
					map[ix][iy]++;			// 값 증가
				}
			}
		}
		area = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]!=0) area++;	// 도화지의 값이 0이 아니라면 area 1증가
//				for(int k=1; k<=N; k++) {
//					if(map[i][j]==k) {		
//						area++;				 
//					}
//				}
			}
		}
		System.out.println(area);	// 면적 출력
	}
}
