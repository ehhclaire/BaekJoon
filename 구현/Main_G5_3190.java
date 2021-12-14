package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 자기 자신의 몸이나 벽이랑 부딪히면 Game Over **/

public class Main_G5_3190 {
	static class Move {
		int X;
		char D;

		public Move(int x, char d) {
			X = x;
			D = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(br.readLine());	// 보드의 크기
		int[][] board = new int[N][N];		// 보드
		
		int K = Integer.parseInt(br.readLine());	// 사과의 개수
		StringTokenizer st = null;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 2;	// 사과 표시
		}
		
		int L = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 횟수 L
		boolean apple = false;	// 사과를 먹은 유무
		int time = 0;	// 걸린 시간
		
		int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};	// 상, 하, 좌, 우
		
		int direction = 3;	// 오른쪽으로 이동 시작
		int r = 0, c = 0;	// 시작 위치
		Queue<int[]> tail = new LinkedList<int[]>();	// 꼬리 정보를 담을 queue
		board[r][c] = 1;	// 시작 위치 표시
		tail.offer(new int[] {r, c});	// 시작 위치 꼬리에 추가
		
		Move[] move = new Move[L];
		for(int l=0; l<L; l++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());	// 전진한 시간
			char D = st.nextToken().charAt(0);	// 회전 방향
			move[l] = new Move(X, D);
		}
		
		int idx = 0;	// 회전 값의 index
		
		while(true) {
			time++;		// 시간 증가
			
			int nr = r + delta[direction][0];
			int nc = c + delta[direction][1];
			
			// 탈출 조건 : 벽이나 자신의 몸과 부딪힌 경우
			if(nr<0 || nr>=N || nc<0 || nc>=N || board[nr][nc]==1) {	
				break;	// 전체 반복 탈출
			}

			// 다음 좌표에 사과가 있는 경우
			if(board[nr][nc]==2) apple = true;	// apple 표시
			else apple = false;
			
			tail.offer(new int[] {nr, nc});	// 다음 위치 꼬리에 저장
			board[nr][nc] = 1;	// 다음 위치 표시			
		
			// 사과를 먹지 않은 경우 뱀 꼬리 삭제
			if(!apple) {
				int[] tailPos = tail.poll();	// 가장 먼저 저장된 꼬리 정보 가져오기
				board[tailPos[0]][tailPos[1]] = 0;	// 꼬리 흔적 삭제	
			}
			
			// time이 현재의 X와 같다면 방향 전환
			if(idx<L && time==move[idx].X) {
				direction = turn(direction, move[idx].D);
				idx++;	// 움직임의 index를 다음 index로 이동
			}		
			
			// 좌표 갱신
			r = nr;
			c = nc;				
		}
		System.out.println(time);		
	}
	
	// 방향 전환 처리
	private static int turn(int direction, char d) {
		// D : 오른쪽으로 90도
		// L : 왼쪽으로 90도
		
		// 1. 현재 위치 : 위
		if(direction==0) {
			if(d=='D') return 3;	// 우
			else return 2;			// 좌
		} 
		// 2. 현재 위치 : 하
		else if(direction==1) {
			if(d=='D') return 2;	// 우
			else return 3;			// 좌
		}
		
		// 3. 현재 위치 : 좌
		else if(direction==2) {
			if(d=='D') return 0;	// 상
			return 1;				// 하
		}
		
		// 4. 현재 위치 : 우
		else {
			if(d=='D') return 1;	// 하
			else return 0;			// 상
		}
	}
	static String src = "10\r\n" + 
			"4\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
}
