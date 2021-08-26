package boj.Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_16926 {
	static int[][] arr;
	static boolean[][] visited;
	static int N, M, R;	
	static int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}};	// 하, 우, 상, 좌
	
	public static void rotate() {
		int turn = 0;		// 회전 변수
		int r = 0, c = 0;	// 처음 위치
		int lastVal = arr[r][c];	// 지난 값을 저장할 변수
		int nextVal = 0;			// 다음 값을 저장할 변수
		visited = new boolean[N][M];
		
		for(int i=0; i<N*M; i++) {
			int nr = r + d[turn][0];	// 다음 좌표의 x값
			int nc = c + d[turn][1]; 	// 다음 좌표의 y값
			
			// 다음 값이 범위 밖이라면,
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) {
				turn = turn+1;	// 회전시키기
				
				if(turn==4) {	// 한바퀴 돌았을 때		
					
					// 현재위치의 오른쪽 대각선 아래 위치의 값을 아직 방문하지 않았더라면,
					if(!visited[r+1][c+1]) {	
						// 해당 위치로 이동	
						r += 1;		
						c += 1;
						turn = 0;	// 방향은 다시 하, 우, 상, 좌 순서로 갈 수 있도록 "하"로 변경
						lastVal = arr[r][c];	// 안쪽으로 들어간 후, 처음 값 lastVal로 저장
					} else {		
						break;		// 제일 안쪽이라면 반복 종료
					}
				}				
				// 안쪽 시작의 다음 x, y좌표값 nr, nc에 저장
				nr = r + d[turn][0];
				nc = c + d[turn][1];
			}
			
			nextVal = arr[nr][nc];	// 다음 좌표 값을 nextVal에 임시 저장
			arr[nr][nc] = lastVal;	// 지난 좌표 값을 다음 좌표값에 저장해줌
			
			lastVal = nextVal;	// 다음 차례에서는 다음 값이 이전 값이 됨으로 값 업데이트
			// 다음 좌표로 이동
			r = nr;				
			c = nc;
			visited[r][c] = true;	// 현 좌표 방문 표시
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/boj_16926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 배열 크기, row 수
		M = Integer.parseInt(st.nextToken());	// 배열 크기, column 수
		R = Integer.parseInt(st.nextToken());	// 회전 수
		
		arr = new int[N][M];
		
		// 2차원 배열 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력받은 횟수만큼 반시계 방향으로 회전
		for(int i=0; i<R; i++) {
			rotate();
		}
		
		// 회전 후, 결과 출력
		for(int[] ar : arr) {
			for(int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}