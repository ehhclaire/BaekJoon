package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16918 {
	static int R, C, map[][];
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};		// 사방 탐색을위한 2차원 배열
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 행의 수
		C = Integer.parseInt(st.nextToken());	// 열의 수
		int N = Integer.parseInt(st.nextToken());	// N초
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			char[] inputs = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				if(inputs[c]=='O') map[r][c] = 3;
				else map[r][c] = -1;
			}
		}
		
		// 1) N이 1일 경우 : 처음 입력 값
		// 2) N이 짝수일 경우 : 전부 폭탄
		// 3) N이 1보다 크고 4로 나누면 나머지가 3인 경우 (3, 7, 11)는 처음 3의 결과랑 동일
		// 4) N이 1보다 크고 4로 나누면 나머지가 1인 경우 (5, 9, 13)는 처음 5의 결과랑 동일
		if(N%2==0) N = 2;
		else if(N>1 && N%4==1) N = 5;
		else if(N>1 && N%4==3) N = 3;

		for(int time=2; time<=N; time++) {
			if(time%2==0) setBomb(time);	// 짝수의 경우 폭탄 설치
			else {
				getBomb(time);	// 폭탄의 위치를 찾기 (함께 동시에 터뜨리기 위해)
				explore();		// 폭탄 폭발
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == -1) System.out.print(".");
				else System.out.print("O");
			}
			System.out.println();
		}		
	}

	// 폭탈 설치
	private static void setBomb(int time) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==-1) map[r][c] = time+3;
			}
		}
	}

	// 폭탄 좌표 얻기
	private static void getBomb(int time) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==time) queue.offer(new int[] {r,c});
			}
		}
	}

	// 폭탄 폭발
	private static void explore() {
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			map[r][c] = -1;
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if(nr>-1 && nr<R && nc>-1 && nc<C) map[nr][nc] = -1;
			}
		}
	}

	static String src = "6 7 3\r\n" + 
			".......\r\n" + 
			"...O...\r\n" + 
			"....O..\r\n" + 
			".......\r\n" + 
			"OO.....\r\n" + 
			"OO.....";
}
