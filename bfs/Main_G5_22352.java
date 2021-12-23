package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_22352 {
	static boolean visited[][]; 
	static int R, C, before[][], after[][];
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		before = new int[R][C];
		after = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				before[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				after[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[R][C];
		
		// before와 after가 다른 값인 첫 영역을 visited를 true로 표시
		boolean check = false;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(before[r][c] != after[r][c]) {
					if(check && !visited[r][c]) {
						System.out.println("NO");
						return;
					}
					check = true;
					bfs(r, c);
				}
			}
		}		
		
		int num = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(visited[r][c]) {
					if(num==0) num = after[r][c];
					else {
						if(after[r][c] != num) {
							System.out.println("NO");
							System.out.println("here2");
							return;
						}
					}
				}
			}	
		}
		
		System.out.println("YES");
	}
			
	// 상,하,좌,우로 인접한 애들끼리 같은 번호를 부여
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if(nr>-1 && nr<R && nc>-1 && nc<C 
						&& !visited[nr][nc]
						&& before[nr][nc]==before[r][c]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}		
	}
	
	static String src = "4 4\r\n" + 
			"2 2 2 1\r\n" + 
			"2 2 1 3\r\n" + 
			"2 1 3 3\r\n" + 
			"1 3 3 3\r\n" + 
			"4 4 4 1\r\n" + 
			"4 4 1 3\r\n" + 
			"4 1 3 3\r\n" + 
			"1 3 3 3";
}