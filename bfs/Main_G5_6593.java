package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// # : 지나갈 수 없는 금
// . : 빈 칸
// S : 시작위치
// E : 도착

public class Main_G5_6593 {
	static class Pos {
		int r, c, floor;

		public Pos(int r, int c, int floor) {
			this.r = r;
			this.c = c;
			this.floor = floor;
		}
	}
		
	//							상		하		좌		우		위층		아랫층
	static int[][] delta = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,1},{0,0,-1}};
	static char[][][] building;
	static int R, C, L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());	// 빌딩 층 수
			R = Integer.parseInt(st.nextToken());	// 한 층의 행 수
			C = Integer.parseInt(st.nextToken());	// 한 층의 열 수
			if(L==0 && R==0 && C==0) break;
			
			building = new char[R][C][L];	// 각 층의 정보를 저장할 3차원 배열
			
			Pos start = null;	// 시작 좌표
			Pos end = null;		// 도착 좌표
			
			for(int i=0; i<L; i++) {
				for(int r=0; r<R; r++) {
					char[] in = br.readLine().toCharArray();
					for(int c=0; c<C; c++) {
						building[r][c][i] = in[c];
						if(in[c]=='S') start = new Pos(r, c, i);	// 시작 좌표 저장
						if(in[c]=='E') end = new Pos(r, c, i);		// 도착 좌표 저장
					}
				}
				br.readLine();	// 층별 입력 사이 빈 줄 버리기
			}
			
			int result = bfs(start, end);
			System.out.println(result==-1 ? "Trapped!" : "Escaped in " + result + " minute(s).");
		}
	}
	private static int bfs(Pos start, Pos end) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {start.r, start.c, start.floor});
		building[start.r][start.c][start.floor] = '#';	// 방문 표시
		
		int time = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				int f = curr[2];
				for(int d=0; d<6; d++) {
					int nr = r + delta[d][0];
					int nc = c + delta[d][1];
					int nf = f + delta[d][2];
					
					if(nr==end.r && nc==end.c && nf==end.floor) return ++time;	// 도착지점이라면 함수 종료
					
					if(nr>-1 && nr<R && nc>-1 && nc<C && nf>-1 && nf<L		// 경계 내에 있으면서
						&& building[nr][nc][nf]!='#') {						// 전진할 곳이 금이 아닌 경우
						
						queue.offer(new int[] {nr, nc, nf});	// 다음 좌표 queue에 넣기
						building[nr][nc][nf] = '#';				// 방문 표시
					}
				}
			}
			time++;
		}
		return -1;
	}
	static String src = "3 4 5\r\n" + 
			"S....\r\n" + 
			".###.\r\n" + 
			".##..\r\n" + 
			"###.#\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"##.##\r\n" + 
			"##...\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"#.###\r\n" + 
			"####E\r\n" + 
			"\r\n" + 
			"1 3 3\r\n" + 
			"S##\r\n" + 
			"#E#\r\n" + 
			"###\r\n" + 
			"\r\n" + 
			"0 0 0";
}
