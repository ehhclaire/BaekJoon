package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G3_1937 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};	
	static int N, bamboo[][], max, dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());	// N x N 크기의 대나무 숲
		bamboo = new int[N][N];		// 대나무 숲 정보
		dp = new int[N][N];			// 메모이제이션을위한 2차원 배열
		
		// 대나무 숲 정보 입력받기
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bamboo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;	// 최대 이동거리를 저장할 변수
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				max = Math.max(max, dfs(r,c));
			}
		}
		System.out.println(max);
	}
	private static int dfs(int r, int c) {
		if(dp[r][c] != 0) return dp[r][c];
		
		int day = 1;
		
		for(int d=0; d<4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			if(nr>-1 && nr<N && nc>-1 && nc<N 	// 경계 내에 있으면서
				&& bamboo[r][c] < bamboo[nr][nc]) {		// 현재 위치보다 대나무가 더 많다면
				day = Math.max(day, dfs(nr, nc)+1);
			}
		}
		dp[r][c] = day;
		return day;
	}
	static String src = "4\r\n" + 
			"14 9 12 10\r\n" + 
			"1 11 5 4\r\n" + 
			"7 15 2 13\r\n" + 
			"6 3 16 8";
}
