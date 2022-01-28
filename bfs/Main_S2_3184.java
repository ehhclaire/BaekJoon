package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_3184 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	static char[][] garden;
	static int R, C, sheeps, wolves;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 행의 수
		C = Integer.parseInt(st.nextToken());	// 열의 수
		
		garden = new char[R][C];
		visited = new boolean[R][C];
		sheeps = 0;		// 살아남은 양의 수
		wolves = 0;		// 살아남은 늑대 수
		
		for(int r=0; r<R; r++) {
			char[] inputs = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				garden[r][c] = inputs[c];
				if(garden[r][c]=='v') wolves++;
				else if(garden[r][c]=='o') sheeps++;
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				// 아직 방문하지 않았으며 현재 위치가 울타리가 아니라면
				if(!visited[r][c] && garden[r][c]!='#') {
					bfs(r,c);	
				}
			}
		}	
		System.out.println(sheeps + " " + wolves);		// 양의 수와 늑대의 수 출력
	}
	
	// bfs로 영역 내 탐색
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[i][j] = true;
		queue.offer(new int[] {i,j});
		
		int s = 0;	// 현재 영역의 양의 수
		int w = 0;	// 현재 영역의 늑대의 수
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			
			// 영역 내의 양의 수와 늑대 수 세기
			if(garden[r][c]=='o') s++;
			else if(garden[r][c]=='v') w++;
			
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				// 영역 내에 있으면서 아직 방문하지 않았고 울타리가 아니라면
				if(nr>-1 && nr<R && nc>-1 && nc<C && !visited[nr][nc] && garden[nr][nc]!='#') {
					queue.offer(new int[] {nr,nc});		// queue에 넣기
					visited[nr][nc] = true;		// 방문처리
				}
			}
		}
		
		if(s > w) wolves -= w;	// 양의 수 > 늑대 수
		else sheeps -= s;	// 늑대 수 > 양의 수
	}
	static String src = "6 6\r\n" + 
			"...#..\r\n" + 
			".##v#.\r\n" + 
			"#v.#.#\r\n" + 
			"#.o#.#\r\n" + 
			".###.#\r\n" + 
			"...###";
}
