package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G4_16954 {
	static int[][] delta = {{0,0},{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};	// 제자리를 포함한 8방 탐색
	static boolean[][] visited;
	static char[][] map;
	static Queue<int[]> wall;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		map = new char[8][8];	// 체스판
		visited = new boolean[8][8];	// 방문 체크
		wall = new LinkedList<int[]>();	// 벽 좌표 저장 queue
		
		for(int i=0; i<8; i++) {
			char[] inputs = br.readLine().toCharArray();
			for(int j=0; j<8; j++) {
				map[i][j] = inputs[j];				
			}			
		}
		
		// 밑에 row부터 벽 정보(#) 저장
		for(int i=7; i>-1; i--) {
			for(int j=0; j<8; j++) {
				if(map[i][j]=='#') {	// 벽이라면 
					wall.offer(new int[] {i,j});	// queue에 좌표 저장
				}
			}
		}
		
		System.out.println(bfs(7, 0));				
	}

	private static int bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {sr, sc});	// 시작 위치 queue에 넣기
		map[sr][sc] = '*';

		while(!queue.isEmpty()) {		
			// 1. 욱제 전진
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				for(int d=0; d<9; d++) {	// 제자리 + 8방 탐색
					int nr = r + delta[d][0];
					int nc = c + delta[d][1];
						
					// 1. 종료 조건 : 오른쪽 위 (0, 7) 도착
					if(nr==0 && nc==7) return 1;	
										
					if(nr>-1 && nr<8 && nc>-1 && nc<8 && map[nr][nc]=='.') {	// 경계 내에있으면서 빈 칸이라면
						map[nr][nc] = '*';	// *로 표시
					}			
				}
			}
			
			// 2. 벽 밑으로 이동
			if(!wall.isEmpty()) {	// 벽 정보가 있다면 
				size = wall.size();
				for(int s=0; s<size; s++) {
					int[] curr = wall.poll();
					int r = curr[0];
					int c = curr[1];
					int nr = r + 1;
					int nc = c;
					if(nr>-1 && nr<8 && nc>-1 && nc<8) {	// 경계 내에있다면
						map[nr][nc] = '#';	// 다음칸으로 벽 이동
						wall.offer(new int[] {nr, nc});
					}
					map[r][c] = '.';	// 현재 위치는 빈 칸으로 변경
				}
			}	
			
			// 벽이동으로 없어지지 않은 욱제의 위치를 queue에 저장
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(map[i][j]=='*') {
						queue.offer(new int[] {i, j});
					}
				}
			}			
			
			
			// 2. 종료 조건 : 욱제의 정보가 하나도 없다면, 도착지로 이동 불가
			if(queue.isEmpty()) return 0;
		}
		return 0;		
	}
	static String src = "........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			".#......\r\n" + 
			"#.......\r\n" + 
			".#......";
}
