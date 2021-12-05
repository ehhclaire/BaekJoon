package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, iceberg[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				iceberg[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visited; 
		int time = 0;
		while(true) {
			int cnt = 0;	// 빙산 그룹 count
			visited = new boolean[N][M];

			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(!visited[r][c] && iceberg[r][c]>0) {
						bfs(r,c, visited);
						cnt++;
					}
					
				}
			}
			if(cnt>1) break;	// 빙산이 두 덩어리 이상으로 분리된 경우 반복 탈출
			time++;		// 시간 증가
			melt();		// 빙산 녹아내리기
			
			boolean gone = true;
			
			// 아직 분리되지 않은체 빙산의 높이가 0이하인 경우 -> 녹을 떄까지 두 덩어리 이상으로 분리되지 않은 경우
			top:
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(iceberg[r][c]>0) {
						gone = false;
						break top;
					}
				}
			}
			if(gone) {
				time = 0;
				break;
			}
		}
		System.out.println(time);		
	}
	
	// 시간이 지나 녹아 내리는 작업
	private static void melt() {
		int[][] offset = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(iceberg[r][c]>0) {
					int cnt = 0;
					for(int d=0; d<4; d++) {	// 사방 탐색
						int nr = r + delta[d][0];
						int nc = c + delta[d][1];
						// 이웃하는 좌표가 물(0)이라면 cnt++
						if(nr>-1 && nr<N && nc>-1 && nc<M && iceberg[nr][nc]<=0) cnt++;
					}
					offset[r][c] = cnt;
				}
			}
		}		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				iceberg[r][c] -= offset[r][c];
			}
		}		
	}
	private static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if(nr>-1 && nr<N && nc>-1 && nc<M 
						&& !visited[nr][nc] 
						&& iceberg[nr][nc]>0) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}		
	}
	static String src = "5 7\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"0 2 4 5 3 0 0\r\n" + 
			"0 3 0 2 5 2 0\r\n" + 
			"0 7 6 2 4 0 0\r\n" + 
			"0 0 0 0 0 0 0";
}
