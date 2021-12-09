package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_2146 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};		// 사방 탐색을 위한 delta 2차원 배열
	static int N, map[][];			// 섬의 크기와 섬 정보
	static boolean visited[][];		// 방문 표시
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];	
		
		int answer = Integer.MAX_VALUE;		// 가장 짧은 다리의 길이
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		int num = 1;	// 부여할 섬 번호
		// 섬 번호 부여하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					mark(i,j,num++);	
				}
			}
		}
		
		// 다리 이어보기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > 0) {
					answer = Math.min(answer, bfs(i, j));	// answer 값을 return 받은 다리길이와 현재까지의 answer 중 최소값으로 갱신
				}
			}
		}
		System.out.println(answer);
	}
	
	// 섬별로 숫자 다르게 표시
	private static void mark(int i, int j, int num) {
		visited[i][j] = true;
		map[i][j] = num;		
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc] && map[nr][nc]==1) {	// 경계 내에 존재면서 아직 방문하지 않았고 1인 경우
					queue.offer(new int[] {nr,nc});	// 방문하기위해 queue에 저장
					visited[nr][nc] = true;		// 방문 표시
					map[nr][nc] = num;			// map에 섬 번호 부여
				}
			}
		}		
	}
	
	// 한 섬에서 다른 섬으로 이을 수 있는 다리의 최소 길이 구하기
	private static int bfs(int i, int j) {
		visited = new boolean[N][N];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		
		int len = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				
				for(int d=0; d<4; d++) {
					int nr = r + delta[d][0];
					int nc = c + delta[d][1];
					if(nr>-1 && nr<N && nc>-1 && nc<N) {	// 경계 내에 존재하면서
						if(map[nr][nc] != 0 && map[nr][nc] != map[i][j]) {	// 다른 섬을 발견하면
							return len;		// 현재까지 이은 다리 길이 return
						}	
						if(!visited[nr][nc] && map[nr][nc]==0) {	// 0인 부분 중에 아직 방문하지 않았다면
							queue.offer(new int[] {nr,nc});			// 방문하기위해 queue에 저장
							visited[nr][nc] = true;		// 방문 표시
						}
					}
				}
			}
			len++;
		}
		return Integer.MAX_VALUE;
		
	}
	static String src = "10\r\n" + 
			"1 1 1 0 0 0 0 1 1 1\r\n" + 
			"1 1 1 1 0 0 0 0 1 1\r\n" + 
			"1 0 1 1 0 0 0 0 1 1\r\n" + 
			"0 0 1 1 1 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
}
