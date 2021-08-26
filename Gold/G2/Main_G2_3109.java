package boj.Gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_3109 {
	private static int[][] d = {{-1,1},{0,1},{1,1}};	// 오른쪽 위, 오른쪽, 오른쪽 아래
	private static char[][] map;
	private static int R, C;
	private static boolean visited[][];
	private static int pipe=0;
	private static boolean check;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/boj_3109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());	// 열 수 
		C = Integer.parseInt(st.nextToken());	// 행 수
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp[j];
				if(tmp[j]=='x') visited[i][j] = true;		// 건물 위치는 미리 방문처리
			}
		}
		
		for(int i=0; i<R; i++) {
			check = false;			// 다른 방향 체크 여부 
			dfs(i,0);	
		}
		System.out.println(pipe);
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;	// 현재 노드 방문으로 체크
		
		if(c==C-1) {			// 마지막 열에 도착했다면
			pipe++;				// pipe 개수 +1
			check = true;		
			return;
		}
		
		int nr = 0, nc = 0;			// 다음 노드
		for(int idx=0; idx<3; idx++) {	// 상우, 우, 하우 방향 탐색
			nr = r + d[idx][0];
			nc = c + d[idx][1];
			if(nr>-1 && nr<R && nc>-1 && nc<C 	// 경계 체크
					&& !visited[nr][nc]) {		// 방문 여부 체크
				dfs(nr, nc);		// 다음 칸으로 전진해서 반복
				if(check) {			// 돌아왔을떄 check가 true이면 반복 탈출
					return;
				}
			}
		}		
	}
}
