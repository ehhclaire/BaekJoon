package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1520 {
	static int N, M, map[][], dp[][];
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());		// 세로 크기
		N = Integer.parseInt(st.nextToken());		// 가로 크기
		
		map = new int[M][N];	// 세준이의 지도
		visited = new boolean[M][N];	// 방문여부 표시
		dp = new int[M][N];		// 메모이제이션을 위한 dp 배열
		
		for(int i=0; i<M; i++) {
			Arrays.fill(dp[i], -1);		// dp 배열을 -1로 초기화
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = true;
		System.out.println(dfs(0,0));
		
		for(int m=0; m<M; m++) {
			for(int n=0; n<N; n++) {
				System.out.print(dp[m][n] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static int dfs(int r, int c) {
		if(r==M-1 && c==N-1) return 1;
		
		if(dp[r][c] != -1) return dp[r][c];		// 이미 방문한 경우 저장된 값을 return
		else {	// 아직 방문하지 않은 경우
			dp[r][c] = 0;	// 0으로 방문 표시
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0]; 
				int nc = c + delta[d][1];
				
				if(nr<0 || nr>=M || nc<0 || nc>=N || visited[nr][nc] || map[r][c] <= map[nr][nc]) continue;
				
				visited[nr][nc] = true;
				dp[r][c] += dfs(nr, nc);
				visited[nr][nc] = false;
			}
		}
		return dp[r][c];
	}
	static String src = "4 5\r\n" + 
			"50 45 37 32 30\r\n" + 
			"35 50 40 20 25\r\n" + 
			"30 30 25 17 28\r\n" + 
			"27 24 22 15 10";
}


