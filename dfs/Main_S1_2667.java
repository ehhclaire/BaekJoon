package boj.Silver.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_2667 {
	static int N, map[][];	// 지도 크기와 지도
	static int cnt = 0;		// 각 단지의 집 수
	static boolean[][] visited;		// 방문 여부 체크
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};		// 사방탐색을 위한 delta 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st = null;
		for(int r=0; r<N; r++) {
			char[] inputs = br.readLine().toCharArray();
			for(int c=0; c<N; c++) {
				map[r][c] = inputs[c] - '0';
			}
		}
		
		int idx = 2;		// 단지에 붙일 번호 : 2 부터 시작
		List<Integer> answer = new ArrayList<Integer>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c] && map[r][c] == 1) {	// 아직 방문하지 않았고 집이 있는 위치라면
					cnt = 0;
					answer.add(dfs(r, c, idx++));
				}
			}
		}
		
		Collections.sort(answer);	// 단지내 집의 수를 오름 차순으로 정렬
		
		System.out.println(answer.size());
		for(Integer a : answer) {
			System.out.println(a);
		}
	}	
	
	// 연결된 영역에 같은 번호로 마킹하기
	private static int dfs(int r, int c, int idx) {
		visited[r][c] = true;	// 현재 위치 방문 처리
		map[r][c] = idx;		// 현재 위치에 단지 번호 마킹
		cnt++;					// 현재 단지의 집의 개수 count
		
		// 사방 탐색
		for(int d=0; d<4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			
			if(nr>-1 && nr<N && nc>-1 && nc<N 	// 경계 내에 존재하면서	
				&& !visited[nr][nc]				// 아직 방문하지 않았고
				&& map[nr][nc]==1) {			// 집이 있는 곳이라면 (map 데이터가 1이라면)
				dfs(nr, nc, idx);		// 해당 방향으로 들어가보기
			}
		}
		return cnt;		// 단지 내 집의 수 return
	}
	static String src = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";
}
