package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G4_1976 {
	static int cities[][], N;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());		// 도시의 수
		int M = Integer.parseInt(br.readLine());		// 여행 계획에 속한 도시들의 수
				
		cities = new int[N][N];		// 도시 별 연결 유무
		int MAX = Integer.MAX_VALUE >> 2;
		
		StringTokenizer st = null;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {				
				cities[r][c] = Integer.parseInt(st.nextToken());
				if(r!=c && cities[r][c]==0) cities[r][c] = MAX;
			}
		}
		
		int[] trip = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			trip[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(cities[i][j] > cities[i][k] + cities[k][j]) {
						cities[i][j] = cities[i][k] + cities[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<M; i++) {
			int from = trip[i-1];
			int to = trip[i];
			if(cities[from][to]==MAX) {
				System.out.println("NO");
				return;
			}
		}		
		System.out.println("YES");
	}
	static String src = "3\r\n" + 
			"3\r\n" + 
			"0 1 0\r\n" + 
			"1 0 1\r\n" + 
			"0 1 0\r\n" + 
			"1 2 3";
}
