package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_G5_10026 {
	private static int N;				// 그리드 크기
	private static char[][] map;		// 색깔 정보 저장 배열
	private static boolean[][] visited; // 방문 여부 체크
	private static int area;			// 구역 개수
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};		// 사방 탐색을 위한 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());	
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp[j];
			}
		}
		
		area = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 아직 방문하지 않았다면 탐색
				if(!visited[i][j]) {
					dfs_RGB(i, j);
					area++;
				}
			}
		}		
		System.out.print(area + " ");
		
		area = 0;
		for(boolean[] v : visited) Arrays.fill(v, false);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 아직 방문하지 않았다면 탐색
				if(!visited[i][j]) {
					dfs_RB(i, j);
					area++;
				}
			}
		}
		System.out.print(area + " ");
	}
	private static void dfs_RB(int r, int c) {
		visited[r][c] = true;
		
		int nr=0, nc=0;
		for(int i=0; i<4; i++) {
			nr = r + d[i][0];
			nc = c + d[i][1];
			
			if(nr>-1 && nr<N && nc>-1 && nc<N	// 범위 내에 있으면서
				&& !visited[nr][nc]) {			// 전진할 노드가 아직 방문하지 않은 곳이고
				
				if((map[r][c]=='R' || map[r][c]=='G') && map[nr][nc]!='B') {	// 현재 위치의 색이 R이나 G일때 이동할 위치의 색이 B가 아니면 전진
					dfs_RB(nr, nc);
				} else if(map[r][c]=='B' && map[nr][nc]=='B') {		// 현재 위치의 색이 B이면서 이동할 위치의 색도 B이면 전진
					dfs_RB(nr, nc);
				}
			}
		}
	}
	private static void dfs_RGB(int r, int c) {
		visited[r][c] = true;
		
		int nr=0, nc=0;
		for(int i=0; i<4; i++) {
			nr = r + d[i][0];
			nc = c + d[i][1];
			
			if(nr>-1 && nr<N && nc>-1 && nc<N	// 범위 내에 있으면서
				&& !visited[nr][nc]				// 전진할 노드가 아직 방문하지 않은 곳이고 
				&& map[r][c]==map[nr][nc]) {	// 현재 노드와 색깔이 같다면
					dfs_RGB(nr, nc);
			}
		}
	}
	static String src = "5\r\n" + 
			"RRRBB\r\n" + 
			"GGBBB\r\n" + 
			"BBBRR\r\n" + 
			"BBRRR\r\n" + 
			"RRRRR";
}
