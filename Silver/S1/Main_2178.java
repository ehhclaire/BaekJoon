package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	static int N, M; // 미로 세로, 가로 길이
	static int sr;	// 시작 노드의 x좌표
	static int sc;	// 시작 노드의 y좌표
	static int er;	// 도착 노드의 x좌표
	static int ec;	// 도착 노드의 y좌표
	static int[][] map;	// 미로 정보
	static boolean[][] visited;	// 방문 여부
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};	// 방향 델타 배열
	static int step;	// 총 이동횟수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String[] inputs = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		sr = 0;
		sc = 0;
		er = N-1;
		ec = M-1;
		step = 1;
		
		bfs();
		System.out.println(step);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();	// 탐색할 노드를 저장할 queue
		
		// 1. 첫 방문한 node를 queue에 담기
		queue.offer(new int[] {sr, sc});
		
		// 2. queue에 담은 node를 방문 처리
		visited[sr][sc] = true;
		
		// 3. 탐색 시작
		// queue에 방문할 node를 담기때문에 queue가 empty(모든 node 방문)일떄까지 탐색
		top:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				
				// 인접 node 방문
				for(int i=0; i<4; i++) {
					int nr = r + d[i][0];
					int nc = c + d[i][1];
				
					// 경계 검사 && 방문하지 않았던 곳이라면 && 갈 수 있는 곳
					if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc] && map[nr][nc]==1) {
						// 인접 node가 도착 node라면
						if(nr==er && nc==ec) {
							step++;
							break top;
						} else {	// 인접 node가 도착위치가 아니면 계속 탐색
							queue.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
			step++;		// 깊이가 증가할때 step 수 증가
		}
	}
}