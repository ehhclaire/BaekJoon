package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_14442 {
	private static boolean[][][] visited;
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int N, M, K;
	private static int[][] map;
	private static int step;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 행 갯수
		M = Integer.parseInt(st.nextToken());	// 열 갯수
		K = Integer.parseInt(st.nextToken());	// 부술수 있는 벽 수 
		
		map = new int[N][M];	// 맵 정보 저장
		visited = new boolean[N][M][11];	// 방문 여부 체크
		
		// 맵 정보 입력받기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		step = 1;
		// 크기가 1x1인 경우, 출발점이 곧 도착점이라 길이가 1
		if(N==1 && M==1) System.out.println(1);
		// 아닌 경우 bfs 탐색
		else bfs();
		
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean arrived = false;
		
		queue.offer(new int[] {0, 0, K});	// 시작 좌표와 부술 수 있는 횟수
		visited[0][0][K] = true;	// 방문 여부 체크
		
		top:
		while(!queue.isEmpty()) {
			int size = queue.size();	
			for(int s=0; s<size; s++) {		// 같은 레벨 처리
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				int bomb = curr[2];
								
				for(int i=0; i<4; i++) {
					int nr = r + d[i][0];
					int nc = c + d[i][1];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc][bomb]) {
						if(nr==N-1 && nc==M-1) {	// 도착 node 이면 종료
							step++;
							arrived = true;
							break top;
						}
						if (map[nr][nc]==0) {		// 이동가능하다면 전진
							queue.offer(new int[] {nr, nc, bomb});
							visited[nr][nc][bomb] = true;
						} else if(map[nr][nc]==1 && bomb>0) {	// 벽이면서 아직 부술 수 있는 횟수가 남아있다면
							queue.offer(new int[] {nr, nc, bomb-1});
							visited[nr][nc][bomb] = true;
						}
					}
				}
			}
			step++;	// 한 레벨이 끝난 경우 step 수 증가
		}
		if(arrived)	System.out.println(step);	// 도착점에 도착한 경우
		else System.out.println(-1);		// 도착점에 도달하지 못한 경우
	}
	static String src = "6 4 1\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1000\r\n" + 
			"0000\r\n" + 
			"0111\r\n" + 
			"0000";
}
