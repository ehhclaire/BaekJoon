package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055 {
	static int R, C;	// R행, C열
	static char[][] map;	// 티떱숲의 지도
	static Queue<int[]> hedgehog; 	// 고슴도치의 이동 정보
	static Queue<int[]> water;		// 물의 이동 정보
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};	// 사방 탐색을위한 delta 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];	
		hedgehog = new LinkedList<int[]>();
		water = new LinkedList<int[]>();
		
		int er = 0, ec = 0;	// 도착지점(비버의 굴 위치)
		
		// 띠텁숲 지도에 정보 입력 받기
		for(int r=0; r<R; r++) {
			char[] inputs = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				map[r][c] = inputs[c];
				// 고슴도치의 위치 저장
				if(map[r][c]=='S') hedgehog.offer(new int[] {r,c});
				if(map[r][c]=='*') water.offer(new int[] {r,c});
				if(map[r][c]=='D') {
					er = r;
					ec = c;
				}
			}
		}		
		
		int result = bfs(er, ec);

		if(result==-1) System.out.println("KAKTUS");
		else System.out.println(result);
	}
	private static int bfs(int er, int ec) {
		int cnt = 0;	// 전진한 횟수
		
		while(!hedgehog.isEmpty()) {

			cnt++;	// 전진한 횟수 증가
			
			// 1. 물 채우기
			int size = water.size();
			for(int w=0; w<size; w++) {
				int[] curr = water.poll();		// queue에 들어있는 물(water)의 위치 빼오기
				int r = curr[0];
				int c = curr[1];
				for(int i=0; i<4; i++) {	// 사방 탐색
					int nr = r + delta[i][0];
					int nc = c + delta[i][1];
					if(nr>-1 && nr<R && nc>-1 && nc<C	// 범위 내에 있다면
						&& map[nr][nc]=='.') {	// 전진할 곳이 빈 공간이라면
						map[nr][nc] = '*';	// 물로 표시
						water.offer(new int[] {nr, nc});	// 전진할 칸의 정보 queue에 저장
					}
				}
			}
			
			// 2. 고슴도치 이동
			size = hedgehog.size();
			for(int s=0; s<size; s++) {
				int[] curr = hedgehog.poll();		// queue에 들어있는 고슴도치(hedgehog)의 위치 빼오기
				int r = curr[0];
				int c = curr[1];
				for(int i=0; i<4; i++) {	// 사방 탐색
					int nr = r + delta[i][0];
					int nc = c + delta[i][1];
					
					if(nr==er && nc==ec) return cnt;	// 비버의 굴에 도달했다면 현재까지 전진한 횟수 return
					
					if(nr>-1 && nr<R && nc>-1 && nc<C	// 범위 내에 있다면
						&& map[nr][nc]=='.') {	// 전진할 곳이 빈 공간이라면
						map[nr][nc] = 'S';	// 고슴도치로 표시
						hedgehog.offer(new int[] {nr, nc});	// 전진할 칸의 정보 queue에 저장
					}
				}	
			}
		}		
		
		return -1;	// 중간에 도착해서 함수를 탈출하지 못했다면 비버의 굴로 도달할 수 없다 ==> -1 return	
	}
	static String src = "3 3\r\n" + 
			"D.*\r\n" + 
			"...\r\n" + 
			".S.";
}
