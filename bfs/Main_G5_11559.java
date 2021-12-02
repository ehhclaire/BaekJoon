package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_11559 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};	// 사방 탐색 delta 배열
	static char field[][];		// 게임 필드
	static int max;				// 최대 연쇄 횟수
	static boolean[][] visited; // 방문 표시
	static ArrayList<int[]> kill;	// 터트릴 좌표를 저장할 list
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		field = new char[12][6];		
		visited = new boolean[12][6];
		kill = new ArrayList<int[]>();
		max = 0;
		
		for(int r=0; r<12; r++) {
			char[] in = br.readLine().toCharArray();
			for(int c=0; c<6; c++) {
				field[r][c] = in[c];
			}
		}
		/*======= 입력 끝 =======*/
		
		boolean check = false;			// 터뜨릴게 있는지 체크
		
		top:
		while(true) {
			visited = new boolean[12][6];	// visited 배열 초기화
			kill = new ArrayList<int[]>();	// 터뜨릴 좌표를 저장할 ArrayList
			
			for(int r=0; r<12; r++) {
				for(int c=0; c<6; c++) {
					if(field[r][c] != '.' && !visited[r][c]) {	// 아직 방문하지 않은 문자를 찾은 경우, bfs 탐색
						bfs(r, c);
						
						if(kill.size()>0) {	// 터뜨릴게 존재한다면
							check = true;	// check를 true로 표시
						}
					}
				}
			}
			if(check) {		// field를 한 번 다 돌았을 때 터드릴게 존재한다면
				remove();	// 터뜨리기
				max++;		// 연쇄 횟수 증가
				gravity();	// 밑으로 내리기 
				check = false;	// check를 false로 초기화
			}
			else break top;		// 터뜨릴게 더 이상 없다면, 종료 
		}		
		System.out.println(max);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		ArrayList<int[]> list = new ArrayList<int[]>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		list.add(new int[] {x, y});
		
		int cnt = 1;	// 붙어있는 개수
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d=0; d<4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if(nr>-1 && nr<12 && nc>-1 && nc<6 && field[r][c] == field[nr][nc] && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					list.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		if(cnt>=4) {	// 연결된게 4개 이상이라면
			// 해당 좌표 값들을 kill ArrayList에 저장
			for(int i=0; i<list.size(); i++) {	
				kill.add(new int[] {list.get(i)[0], list.get(i)[1]});	
			}
		}
	}
	
	// kill 안에 저장된 좌표를 . 으로 표시
	private static void remove() {
		for(int i=0; i<kill.size(); i++) {
			int r = kill.get(i)[0];
			int c = kill.get(i)[1];
			field[r][c] = '.';
		}
	}
	
	// 제거 후, 좌표 밑으로 내리기
	private static void gravity() {	
		for(int c=0; c<6; c++) {
			Queue<Character> queue = new LinkedList<Character>();
		
			// 세로 밑부분으로 탐색을 하면서 . 이 아닌 값들을 queue에 저장
			for(int r=11; r>-1; r--) {
				if(field[r][c]!='.') {
					queue.offer(field[r][c]);
				}
			}
			
			// 각 열별로 queue에 값이 존재하면 밑에서 부터 저장하고 나머지 부분은 . 으로 표시
			for(int r=11; r>-1; r--) {
				if(!queue.isEmpty()) field[r][c] = queue.poll();
				else field[r][c] = '.';
			}
		}
	}
	static String src = "......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			".Y....\r\n" + 
			".YG...\r\n" + 
			"RRYG..\r\n" + 
			"RRYGG.";
}
