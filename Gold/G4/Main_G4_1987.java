package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1987 {
	private static int R;
	private static int C;
	private static boolean[] used;
	private static char[][] map;
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int cnt = 1;
	private static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());	// 세로
		C = Integer.parseInt(st.nextToken());	// 가로
		used = new boolean[26];
		map = new char[R][C];
		
		// 보드 정보 입력받기
		for(int i=0; i<R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp[j];
			}
		}
		
		dfs(0,0);
		System.out.println(answer);
	}

	private static void dfs(int r, int c) {
		used[map[r][c]-'A'] = true;		// 사용 체크
		
		int nr=0, nc=0; 	// 다음 좌표
		for(int i=0; i<4; i++) {
			nr = r + d[i][0];
			nc = c + d[i][1];
			if(nr>-1 && nr<R && nc>-1 && nc<C 	 // 경계 체크
					&& !used[map[nr][nc]-'A']) { // 중복 여부 (사용여부) 체크 
				cnt++;			// 읽은 단어 개수 하나 추가
				dfs(nr, nc);	// 다음 좌표 읽기
			} 
		}
		used[map[r][c]-'A'] = false;	// 다음 검색을 위해 현재 쓴거 false로 전환
		answer = Math.max(answer, cnt);	// 읽은 알파벳의 최대 값으로 갱신	
		cnt--;							// 다른 갈래길로 가서 읽기위해 cnt--;
		return;
	}
}

