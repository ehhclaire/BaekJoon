package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1303 {
	static int N;			// 가로크기
	static int M;			// 세로크기
	static char[][] map;		// 전쟁터 정보
	static boolean[][] visited;		// 방문 체크
	
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};	// 사방 탐색을 위한 delta 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = arr[j];
			}
		}
		
		int totalWhite = 0;
		int totalBlue = 0;
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					int[] result = bfs(i, j);
					totalWhite += result[0] * result[0];
					totalBlue += result[1] *result[1];
				}
			}
		}
		System.out.println(totalWhite + " " + totalBlue);
	}
	private static int[] bfs(int x, int y) {		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		int sumBlue = 0;
		int sumWhite = 0;
		
		if(map[x][y]=='B') sumBlue++;
		else sumWhite++;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int r = pos[0];
			int c = pos[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + d[i][0];
				int nc = c + d[i][1];
				if(nr>-1 && nr<M && nc>-1 && nc<N		// 경계 내에 있으며
						&& !visited[nr][nc]				// 방문하지 않았고
						&& map[r][c]==map[nr][nc]) {	// 현재 값과 같은 색상을 가졌다면
					if(map[r][c]=='B') sumBlue++;
					else sumWhite++;
					visited[nr][nc]=true;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		return new int[] {sumWhite, sumBlue};
	}
	static String src = "5 5\r\n" + 
			"WBWWW\r\n" + 
			"WWWWW\r\n" + 
			"BBBBB\r\n" + 
			"BBBWW\r\n" + 
			"WWWWW";
}
