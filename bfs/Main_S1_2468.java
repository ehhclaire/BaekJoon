package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468 {
	static int N, map[][], answer;
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());	// 지역의 크기
		map = new int[N][N];	// 지역 정보 저장 2차원 배열
		ArrayList<Integer> list = new ArrayList<Integer>();	// 높이 정보를 담을 ArrayList
		
		// 지역 정보 입력 받기
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(!list.contains(map[i][j])) list.add(map[i][j]);	// 주어진 높이를 중복없이 list에 저장
			}
		}
		
		answer = Integer.MIN_VALUE;	// 최대 안전지역 수 저장
		for(int s=0; s<list.size(); s++) {	// 높이별로 탐색
			visited = new boolean[N][N];	// 방문 정보 
			int cnt = 0;	// 안전지역 수
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 아직 방문하지 않았고 기준 높이보다 높은 지역이라면, 침수하지 않았음으로 BFS 탐색
					if(!visited[i][j] && map[i][j]>list.get(s)) {	
						bfs(i, j, list.get(s));
						cnt++;	// 안전지역 1개 증가
					}
				}
			}
			answer = Math.max(answer, cnt);	// 더 많은 안전지역 수로 answer 갱신
		}
		System.out.println(answer==0?1:answer);	// 만약 answer이 0이면, 전체가 안전지역 덩어리인 경우인 1로 출력
	}
	
	private static void bfs(int x, int y, Integer height) {
		// 사방탐색을 위한 delta 배열
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		Queue<int[]> queue = new LinkedList<int[]>();	// 이어진 지역 좌표 정보를 저장할 queue
		// 시작위치 queue에 저장 및 방문 표시
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();	// 현재 좌표
			int r = curr[0];
			int c = curr[1];
			
			int nr=0, nc=0;
			for(int d=0; d<4; d++) {	// 사방 탐색
				nr = r + dr[d];
				nc = c + dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<N 	// 경계 내에있으며
					&& !visited[nr][nc] 			// 아직 방문하지 않았고
					&& map[nr][nc]>height) {		// 기준 높이보다 높다면
					queue.offer(new int[] {nr, nc});	// 해당 좌표로 전진
					visited[nr][nc] = true;	// 해당 좌표 방문 표시
				}
			}
		}		
	}
	static String src = "5\r\n" + 
			"6 8 2 6 2\r\n" + 
			"3 2 3 4 6\r\n" + 
			"6 7 3 3 2\r\n" + 
			"7 2 5 3 6\r\n" + 
			"8 9 5 2 7";
}
