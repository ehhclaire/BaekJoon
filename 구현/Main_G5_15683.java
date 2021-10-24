package boj.Gold;


import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_15683 {
	static int N, M, size, numbers[], office[][], backup[][], answer;
	static ArrayList<int[]> cctv;
	static String[][] direction = {{"0","0","0","0"},
						 {"3","1","2","0"},
						 {"23","01","23","01"},
						 {"03","31","12","20"},
						 {"203","031","312","120"},
						 {"0123","0123","0123","0123"}};
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 세로 크기
		M = Integer.parseInt(st.nextToken());	// 가로 크기 
		office = new int[N][M];		// 사무실
		backup = new int[N][M];		// 백업용 사무실 정보
		
		cctv = new ArrayList<int[]>();
		answer = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				backup[i][j] = office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j]>0 && office[i][j]!=6) cctv.add(new int[] {i,j,office[i][j]});
			}
		}
		
		size = cctv.size();
		numbers = new int[size];	// 각 cctv별 모든 경우의 방향
		
		permutation(0);
		
		System.out.println(answer);
	}
	private static void permutation(int cnt) {
		if(cnt==size) {
//			System.out.println(Arrays.toString(numbers));
			monitor();
			count();
			reset();
			return;
		}
		
		for(int i=0; i<4; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}		
	}	
	
	private static void monitor() {
		
		for(int i=0; i<size; i++) {
			String dir = direction[cctv.get(i)[2]][numbers[i]];
//			System.out.println(cctv.get(i)[2]+"번 cctv를 "+dir+"방향으로 옮겨볼거야");
			for(int d=0; d<dir.length(); d++) {
				int r = cctv.get(i)[0];
				int c = cctv.get(i)[1];
				
				while(true) {
//					System.out.println("그 중에서도 "+dir.charAt(d)+"방향으로 ~~");
					int nr = r + delta[dir.charAt(d)-'0'][0];
					int nc = c + delta[dir.charAt(d)-'0'][1];
				
					if(nr<0 || nr>=N || nc<0 || nc>=M) break;	// 경계 밖을 나가는 경우, 탈출
//					if(office[nr][nc]!=0) break;				// 빈칸이 아닌 경우, 탈출
					if(office[nr][nc]==6) break;
					office[nr][nc] = -1;
					r = nr;
					c = nc;	
				}
			}			
		}	
	}
	
	// 사각지대 개수 계산
	private static void count() {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(office[i][j]==0) cnt++;
			}
		}
//		if(answer>cnt) {
//			System.out.println(Arrays.toString(numbers));
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(office[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		answer = Math.min(answer, cnt);
	}
	
	// 사무실 정보 초기화
		private static void reset() {
			for(int i=0; i<N; i++) {
				office[i] = backup[i].clone();
			}
		}
	static String src = "6 6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 2 0 0 0 0\r\n" + 
			"0 0 0 0 6 0\r\n" + 
			"0 6 0 0 2 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 5";
}
