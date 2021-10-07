package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G2_17143 {
	static int[][] map;
	static Shark[] shark;
	static int R, C, M, answer;
	static int[][] delta = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};	// 위, 아래, 오른쪽, 왼쪽
	
	static class Shark {
		int r, c;		// 상어의 위치 좌표
		int s, d, z;	// 속력, 이동방향, 크기
	
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 격자판 R 크기
		C = Integer.parseInt(st.nextToken());	// 격자판 C 크기
		M = Integer.parseInt(st.nextToken());	// 상어 수
		
		map = new int[R][C];	// 격자판
		shark = new Shark[M];
		
		answer = 0;		// 총 낚시한 상어 수
	
		/**
		 * 1. 낚시왕 오른쪽으로 한 칸 이동
		 * 2. 낚시왕이 서있는 열에서 땅과 가장 가까운 상어 잡기
		 * 3. 상어 이동 
		 */
		
		if(M==0) {
			System.out.println(0);
			return;
		}
		
		// 상어의 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;	// 좌표 인덱스 맞추기
			int y = Integer.parseInt(st.nextToken())-1;	// 좌표 인덱스 맞추기
			int speed = Integer.parseInt(st.nextToken());	// 속도
			int direction = Integer.parseInt(st.nextToken());	// 방향
			int size = Integer.parseInt(st.nextToken());	// 크기
			
			shark[i] = new Shark(x, y, speed, direction, size);
			map[x][y] = i+1;	// 좌표에 상어 번호 추가
		}

		for(int c=0; c<C; c++) {
			// 1. 낚시왕의 낚시 시작
			fishing(c);
			
			// 2. 상어의 이동
			move();
			
			// 3. 상어간의 싸움
			attack();
			
		}
		System.out.println(answer);
	}

	private static void fishing(int c) {
		for(int r=0; r<R; r++) {	// 행별로 탐색하면서
			if(map[r][c]!=0) {	// 가장 먼저 나온 상어 낚시
				answer += shark[map[r][c]-1].z;
				shark[map[r][c]-1] = null;		
				break;
			}
		}
	}

	private static void move() {
		for(int m=0; m<M; m++) {
			// 제거된 상어인 경우
			if(shark[m]==null) continue;
			
			int speed = shark[m].s;		// 현재 상어의 속도
			int direction = shark[m].d;	// 현재 상어의 이동 방향
			
			// 상어가 이동할 크기 줄여주기
			if(direction==1 || direction==2) {	// 상, 하인 경우
				speed = speed % (R*2-2);	// 행의 수로 조절
			} else {	// 좌, 우인 경우
				speed = speed % (C*2-2);	// 열의 수로 조절
			}
			
			int r = shark[m].r;
			int c = shark[m].c;

			for(int j=0; j<speed; j++) {
				int nr = r + delta[direction][0];
				int nc = c + delta[direction][1];				
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) {	// 다음 좌표가 경계 밖이라면
					if(direction==1 || direction==3) direction+=1;
					else direction -= 1;
					nr = r + delta[direction][0];
					nc = c + delta[direction][1];
				}
				r = nr;
				c = nc;
			}
			// 좌표 갱신
			shark[m].r = r;
			shark[m].c = c;
			// 방향 갱신
			shark[m].d = direction;
		}
	}

	private static void attack() {
		for(int i=0; i<R; i++) {
			Arrays.fill(map[i], 0);
		}
		for(int i=0; i<M; i++) {
			if(shark[i]==null) continue;
			int r = shark[i].r;
			int c = shark[i].c;
			if(map[r][c]==0) {
				map[r][c] = (i+1);
			} else {
				
				if(shark[map[r][c]-1]!=null && shark[map[r][c]-1].z < shark[i].z) {
					shark[map[r][c]-1] = null;	// 기존의 위치에있는 상어 잡아먹기
					map[r][c] = (i+1);
				} else {
					shark[i] = null;
				}

			}
		}

	}

	static String src = "100 7 7\r\n" + 
			"3 2 2 3 9\r\n" + 
			"3 3 1 3 3\r\n" + 
			"3 5 1 4 7\r\n" + 
			"3 6 2 4 6\r\n" + 
			"2 4 1 2 8\r\n" + 
			"1 4 2 2 4\r\n" + 
			"4 4 1 1 5";
}
