package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2589 {
	static int R, C;
	static char[][] map;		// 보물섬 지도 정보를 담을 2차원 배열
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};	// 사방 탐색 delta 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		/*===== 입력 시작 =====*/
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());		// 가로 길이 
		C = Integer.parseInt(st.nextToken());		// 세로 길이
		
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			char[] input = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				map[r][c] = input[c];
			}
		}		
		/*===== 입력 끝 =====*/
		
		int max = 0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]=='L') {
					max = Math.max(max, bfs(r, c));
				}
			}
		}
		System.out.println(max);
	}
	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[R][C];

		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		int dist = -1;	// 두 곳 사이의 거리
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				for(int d=0; d<4; d++) {
					int nr = r + delta[d][0];
					int nc = c + delta[d][1];
					if(nr>-1 && nr<R && nc>-1 && nc<C 	// 경계 내에 있으면서
							&& !visited[nr][nc] 		// 아직 방문하지 않았으면서
							&& map[nr][nc]=='L') {		// 육지인 경우
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
			dist++;
		}
		return dist;
	}
	static String src = "5 7\r\n" + 
			"WLLWWWL\r\n" + 
			"LLLWLLL\r\n" + 
			"LWLWLWW\r\n" + 
			"LWLWLLL\r\n" + 
			"WLLWLWW";
}
